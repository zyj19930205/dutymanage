layui.use(['layer', 'form','table','laypage','element'], function(){
    var layer = layui.layer
        ,form = layui.form,table=layui.table,element=layui.element;
});

layui.use(['table', 'form'], function() {
    var table = layui.table;
     form = layui.form;
    //第一个实例
    table.render({
        elem: '#empList'
        ,height: 'full-200'
        ,url: 'getEmployeeByPage' //数据接口
        ,page: true //开启分页
        ,limit:20
        ,limits:[20,25,30,40]
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title:'排班数据表'
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'name', title: '姓名'}
            ,{field: 'gender', title: '性别', sort: true}
            ,{field: 'remarks', title: '备注'}
            ,{field: 'empDutyTypeIds', title: '值班类型'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
        ]]
    });

    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;
            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        };
    });


    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('确认删除员工？', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit') {
            dataBindToTC(data);
            layer.open({
                    type:1,
                    area:['600px','600px'],
                    title: '员工管理'
                    ,content: $("#modifyEmp"),
                    shade: 0,
                    btn: ['提交', '重置']
                    ,btn1: function(index, layero){
                        changeEmp(obj);
                    parent.layui.table.reload('empList');//重载父页表格，参数为表格ID
                    layer.close(index);
                    },
                    btn2: function(index, layero){
                        return false;
                    },
                    cancel: function(layero,index){
                        layer.closeAll();
                    }
                }
            );

        } else if(obj.event === 'detail'){
            layer.alert('此人名为'+ JSON.stringify(data.name))
        }
    });

});

//给弹窗绑定数据
function dataBindToTC(data) {
    $('#username').val(data.name);
    var gender=data.gender;

    if(gender=='男'){
        $("input:radio[name='sex'][value='男']").prop("checked",true);
    }else{
        $("input:radio[name='sex'][value='女']").prop("checked",true);
    }

    var checkboxes=$("input:checkbox[name='dutyType']");
    checkboxes.prop("checked",false);
    var dutyTypes=data.empDutyTypeIds;
    if(dutyTypes!='undefined' && dutyTypes!=null && dutyTypes!=''){

        var arr=dutyTypes.split(',');
        //给复选框绑定数据
        $.each(arr, function (index, arrId) {
            checkboxes.each(function () {
                if ($(this).val() == arrId) {
                    $(this).prop("checked", true);
                }
            });
        });
}
    form.render();
}

/*
修改员工信息
 */
function changeEmp(obj) {
    var dutyType = new Array();
    // var dutyType_all;
    $("input:checkbox[name='dutyType']:checked").each(function (i) {
        dutyType[i] = $(this).val();
    });
    $.ajax({
        //请求方式
        type : "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "modifyEmployee?dutyType="+dutyType+"&id="+obj.data.id,
        //数据，json字符串
        //请求成功
        success : function(result) {
            layer.alert('修改成功！', {icon: 6});
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}


/*
获取临时排表结果
 */
layui.use(['table', 'form'], function() {
    var table2 = layui.table;
    form = layui.form;
    //第一个实例
    table2.render({
        elem: '#dutyList'
        ,height: 'full-200'
        ,url: 'getTempDutyResult' //数据接口
        ,page: true //开启分页
        ,limit:20
        ,limits:[20,25,30,40]
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title:'排班数据表'
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'empId', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'empName', title: '姓名'}
            ,{field: 'dutyDate', title: '值班日期', sort: true}
            ,{field: 'typeName', title: '值班类型'}
            // ,{field: 'empDutyTypeIds', title: '值班类型'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
        ]]
    });

    table2.on('toolbar(dutyTable)', function(obj){
        var checkStatus = table2.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;
            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        };
    });


    //监听行工具事件
    table2.on('tool(dutyTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('确定删除该值班数据？', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit') {
            dataBindToDutyTable(data);
            layer.open({
                    type:1,
                    area:['600px','600px'],
                    title: '排班管理'
                    ,content: $("#modifyDuty"),
                    shade: 0,
                    btn: ['提交', '重置']
                    ,btn1: function(index, layero){
                    layer.confirm('确定更改排班日期？', {
                        btn: ['确定','不，我点错了'] //按钮
                    }, function(){
                        isSameDutyDateExist(obj);
                        // changeDuty(obj);
                        parent.layui.table.reload('dutyList');//重载父页表格，参数为表格ID
                        layer.close(index);
                    }, function(){
                        layer.msg('如果不需要修改，请直接点×哦~', {
                            time: 20000, //20s后自动关闭
                            btn: ['明白了', '知道了']
                        });
                    });

                    },
                    btn2: function(index, layero){
                        return false;
                    },
                    cancel: function(layero,index){
                        layer.closeAll();
                    }
                }
            );

        } else if(obj.event === 'detail'){
            layer.alert('此人名为'+ JSON.stringify(data.empName))
        }else if(obj.event === 'changeDuty'){
            dataBindToCD(obj);
           layer.open({
               type:1,
               area:['600px','600px'],
               title: '排班管理'
               ,content: $("#changeDuty"),
               shade: 0,
               btn: ['确认', '不确认']
               ,btn1:function (index, layero) {
                   replaceEmpDutyResult(obj);
               }
           })
        }
    });

});

//为值班列表绑定数据
function dataBindToDutyTable(data){
    var dutyTypeName;
    $('#username').val(data.empName);
    var dutyTypeId=data.dutyTypeId;
    if(dutyTypeId==2){
        dutyTypeName="假日班";
    }else {
        dutyTypeName="不知道啥班";
    }
    $('#dutyType').val(dutyTypeName);
    $('#dutyDate').val(data.dutyDate);
}


// 修改员工信息
function changeDuty(obj) {
    var dutyDate=$('#dutyDate').val();
    $.ajax({
        //请求方式
        type : "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "modifyTempDutyResult?dutyDate="+dutyDate+"&id="+obj.data.id,
        //数据，json字符串
        //请求成功
        success : function(result) {
            console.log(result);
            layer.alert('修改成功！', {icon: 6});
            parent.layui.table.reload('dutyList');
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

function dataBindToCD(obj) {
    $('#user_name').val(obj.data.empName);
    $('#duty_Type').val(obj.data.typeName);
    $('#duty_Date').val(obj.data.dutyDate);
}

//判断是否存在相同的值班日期
function isSameDutyDateExist(obj){
    var dutyDate=$('#dutyDate').val();
    alert(dutyDate);
    $.ajax({
        //请求方式
        type : "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "isDutyDateExist?dutyDate="+dutyDate,
        //数据，json字符串
        //请求成功
        success : function(result) {
            console.log(result);
            if(result === true){
                layer.confirm('存在相同的值班日期，是否确定换班？', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    changeDuty(obj);
                }, function(){
                    layer.msg('已取消');
                });
            }else {
                changeDuty(obj);
                // layer.alert("继续？");
            }
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

function replaceEmpDutyResult(){
    var emp_name_1=$('#user_name').val();
    var emp_name_2=$('#other_user_name').val();
    var emp_date_1=$('#duty_Date').val();
    var emp_date_2=$('#duty_date_select').val();
    $.ajax({
        //请求方式
        type : "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "replaceEmpDutyResult?dutyDate1="+emp_date_1+"&dutyDate2="+emp_date_2+"&empName1="+emp_name_1+"&empName2="+emp_name_2,
        //数据，json字符串
        //请求成功
        success : function(result) {
            console.log(result);
            layer.alert('换班成功！', {icon: 6});
            parent.layui.table.reload('dutyList');
            layer.close();
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

