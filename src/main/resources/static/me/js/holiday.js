layui.use(['layer', 'form','table','laypage','element'], function(){
    var layer = layui.layer
        ,form = layui.form,table=layui.table,element=layui.element;
});

layui.use(['table', 'form'], function() {
    var table = layui.table;
    form = layui.form;
    //第一个实例
    table.render({
        elem: '#HolidayList'
        , height: 'full-200'
        , url: 'getHolidays' //数据接口
        , page: true //开启分页
        , width: 600
        , limit: 20
        , limits: [20, 25, 30, 40]
        // ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        // ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
        //     title: '提示'
        //     ,layEvent: 'LAYTABLE_TIPS'
        //     ,icon: 'layui-icon-tips'
        // }]
        , title: '假日展示表'
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
            , {field: 'holidayName', title: '假日名'}
            , {field: 'holidayDate', title: '日期', sort: true}
            // ,{field: 'remarks', title: '备注'}
            // ,{field: 'empDutyTypeIds', title: '值班类型'}
            // ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
        ]]
    });
});
