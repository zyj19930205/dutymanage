package cn.jx.chinunicom.dutymanage.service.impl;

import cn.jx.chinunicom.dutymanage.entity.*;
import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.TempDutyResultBo;
import cn.jx.chinunicom.dutymanage.mapper.*;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import cn.jx.chinunicom.dutymanage.service.TempDutyResultService;
import cn.jx.chinunicom.dutymanage.util.DutyDays;
import cn.jx.chinunicom.dutymanage.util.DutyRules;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempDutyResultImpl implements TempDutyResultService {
    @Autowired
    TempDutyResultMapper tempDutyResultMapper;
    @Autowired
    DutyQueueMapper dutyQueueMapper;
    @Autowired
    HolidayMapper holidayMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SpecialDutyMapper specialDutyMapper;

    @Override
    public List<TempDutyResult> getTempDutyResult() {
        return tempDutyResultMapper.selectList(null);
    }

    @Override
    public ResultMsg getTempDutyResultByPage(int page,int limit) {
        Page<TempDutyResult> tempDutyResultPage=new Page<>(page,limit);
        IPage<TempDutyResult> iPage=tempDutyResultMapper.getTempDutyResultByPage(tempDutyResultPage);
        List<TempDutyResult> tempDutyResults=iPage.getRecords();
        List<TempDutyResultBo> tempDutyResultBos=changeResultToBo(tempDutyResults);
        ResultMsg resultMsg=ResultMsg.createBySuccess(iPage.getTotal(),tempDutyResultBos);
        return resultMsg;
    }

    private List<TempDutyResultBo> changeResultToBo(List<TempDutyResult> tempDutyResults) {
        List<TempDutyResultBo> tempDutyResultBos=new ArrayList<>();
        TempDutyResultBo tempDutyResultBo;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(TempDutyResult tempDutyResult:tempDutyResults){
            tempDutyResultBo=new TempDutyResultBo();
            tempDutyResultBo.setId(tempDutyResult.getId());
            tempDutyResultBo.setEmpId(tempDutyResult.getEmpId());
            tempDutyResultBo.setEmpName(tempDutyResult.getEmpName());
            tempDutyResultBo.setDutyDate(sdf.format(tempDutyResult.getDutyDate()));
            tempDutyResultBo.setDutyTypeId(tempDutyResult.getDutyTypeId());
            tempDutyResultBo.setTypeName(tempDutyResult.getTypeName());
            tempDutyResultBos.add(tempDutyResultBo);
        }
        return tempDutyResultBos;
    }

    @Override
    public boolean isDutyDateExist(Date dutyDate) {
        return tempDutyResultMapper.selectTempDutyResultByDutyDate(dutyDate)==null?false:true;
    }

    @Override
    public ResultMsg updateTempDutyResult(int id, Date date) {
        try{
            tempDutyResultMapper.updateDutyDateByEmpId(id, date);
            return ResultMsg.createBySuccess();
        }catch (Exception e){
            return ResultMsg.createByFail();
        }
    }

    /*
    换班方法
     */
    @Override
    public ResultMsg changeDutyWithTwoEmp(String empName1,String empName2,Date date1,Date date2) {
        //1.在临时排班表中替换
        TempDutyResult tempDutyResult_1=tempDutyResultMapper.selectByDutyDateAndEmpName(empName1,date1);//被换班的人
        TempDutyResult tempDutyResult_2=tempDutyResultMapper.selectByDutyDateAndEmpName(empName2,date2);//要换的人
        System.out.println(tempDutyResult_1+","+tempDutyResult_2);
        tempDutyResultMapper.updateDutyById(tempDutyResult_2.getEmpId(),empName2,tempDutyResult_1.getId());
        tempDutyResultMapper.updateDutyById(tempDutyResult_1.getEmpId(),empName1,tempDutyResult_2.getId());
        QueryWrapper<DutyQueue> dutyQueueQueryWrapper_1=new QueryWrapper<>();
        QueryWrapper<DutyQueue> dutyQueueQueryWrapper_2=new QueryWrapper<>();
        dutyQueueQueryWrapper_1.eq("empId",tempDutyResult_1.getEmpId());
        dutyQueueQueryWrapper_2.eq("empId",tempDutyResult_2.getEmpId());
        DutyQueue dutyQueue1=dutyQueueMapper.selectOne(dutyQueueQueryWrapper_1);
        DutyQueue dutyQueue2=dutyQueueMapper.selectOne(dutyQueueQueryWrapper_2);
        System.out.println(dutyQueue1+","+dutyQueue2);
        dutyQueueMapper.updateEmpNameAndEmpId(dutyQueue2.getEmpId(),dutyQueue2.getEmpName(),dutyQueue1.getRowId());
        dutyQueueMapper.updateEmpNameAndEmpId(dutyQueue1.getEmpId(),dutyQueue1.getEmpName(),dutyQueue2.getRowId());
//        tempDutyResultMapper.updateDutyById(tempDutyResult_1);
        return ResultMsg.createBySuccess();
    }

    @Override
    public  List<TempDutyResult> findDutyByUserName(String username) {
        QueryWrapper<TempDutyResult> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("empName",username);
        List<TempDutyResult> tempDutyResult=tempDutyResultMapper.selectList(queryWrapper);
        return tempDutyResult;
    }

    @Override
    public List<Date> findDateByEmpName(String empName) {
        QueryWrapper<TempDutyResult> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("empName",empName);
        List<TempDutyResult> tempDutyResult=tempDutyResultMapper.selectList(queryWrapper);
        List<Date> dateList=tempDutyResult.stream().map(TempDutyResult::getDutyDate).collect(Collectors.toList());
        return dateList;
    }


    /**
     * 自动排班
     * @param beginDate
     * @param endDate
     * 排班顺序：1.节假日   2.特殊值班  3.周四晚班  4.周末白班  5.普通晚班
     */
    @Override
    public List<DateWithEmp> autoDutyByDay(Date beginDate, Date endDate) throws ParseException{
        List<DateWithEmp> dateWithEmpList=new ArrayList<>();//临时排班总表
        List<Employee> dutyedEmplist=new ArrayList<>();//已经被排班员工
        List<Employee> HolidayDutyedEmpList=new ArrayList<>();//假日已排班员工
        List<Date> holiday_tx_date=holidayMapper.getHolidayByHolidayType(7);//获取调休日
        List<DateWithEmp> holiday_dateWithEmpList=new ArrayList<>();//假日排班表
        List<DateWithEmp> last_holiday_dutyEmp = new ArrayList<>();//上个节假日排班人员
        List<DateWithEmp> special_dateWithEmpList=new ArrayList<>();//特殊情况排班表
        List<Date> need_duty_date= DutyUtils.getDates(beginDate,endDate);
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(beginDate,endDate);
        //不要把调休算进假日中哦~
        holiday_date.removeAll(holiday_tx_date);
        /*
        1.假日排班
         */
        if(holiday_date.size()!=0){
            holiday_dateWithEmpList=auto_holiday_duty(holiday_date,dutyedEmplist,beginDate);
            need_duty_date.removeAll(holiday_date);
        }
        HolidayDutyedEmpList=extractDutyedEmpList(holiday_dateWithEmpList,dutyedEmplist);

        //筛选出上个月节假日值班人员，将他们放在末尾
//        Integer last_year = beginDate.getYear() + 1900;
//        Integer last_month = beginDate.getMonth() + 1;
//        List<Employee> last_holidays_dutyed_empList=employeeMapper.selectFromFormalDutyByDutyTypeId(last_year,last_month,new int[]{DutyRules.假日白班.getStatusCode(),DutyRules.假日晚班.getStatusCode()});
        /*
        2.特殊人员排班
         */
//        if(specialDutyMapper.selectSpecialRuleEmp().size()!=0){
//            special_dateWithEmpList=specialDuty(need_duty_date,beginDate,endDate,special_dateWithEmpList);
//            for(DateWithEmp dateWithEmp:special_dateWithEmpList){
//                need_duty_date.remove(dateWithEmp.getDutyDate());
//            }
//        }
        /*
        3.普通排班-周四晚班
         */
        List<Employee> temp_as=new ArrayList<>();
        List<Employee> thursday_duty_emp=dutyQueueMapper.selectQueueToEmployee(DutyRules.周四晚班.getStatusCode());

        //thursday_duty_emp=removeDutyedEmp(thursday_duty_emp,dutyedEmplist);
        thursday_duty_emp.removeAll(HolidayDutyedEmpList);//移除掉假日已经排过班的人
        List<Date> thursday_duty_date=getWeekList(need_duty_date,DutyDays.THURSDAY.getDay());
        List<DateWithEmp> thursday_duty_list=DateAndEmpAdapter(thursday_duty_date,thursday_duty_emp);
        setDutyRemark(thursday_duty_list,DutyRules.周四晚班.getStatusCode());
        putToQueueFoot(thursday_duty_list);  //将已排班的人移动到队列末尾

        /*
        4 普通排班-周末白班
         */
//        dutyedEmplist=extractDutyedEmpList(thursday_duty_list,dutyedEmplist);//获取已经被排班的人员
        int weekend_mo_duty[]={DutyRules.周六白班.getStatusCode(),DutyRules.周日白班.getStatusCode()};
        List<Employee> weekend_morning_duty_emp=dutyQueueMapper.selectQueueToEmployeeByArray(weekend_mo_duty);//周末白班排班人员队列
        weekend_morning_duty_emp.removeAll(HolidayDutyedEmpList);
        System.out.println("周末白班人员队列为"+weekend_morning_duty_emp);
        //查询上个月值过白班的人员，并将这些人移动到队列末尾
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
        String lastMonthDate = sdf.format(beginDate);
        List<Employee> lastWeekDutyedEmp = dutyQueueMapper.selectLastMonthWeekendMorningEmp(lastMonthDate);
        weekend_morning_duty_emp.removeAll(lastWeekDutyedEmp);
        weekend_morning_duty_emp.addAll(lastWeekDutyedEmp);

        List<Date> weekend_duty_Date=getWeekList(need_duty_date,DutyDays.WEEKEND_DUTY_DAY);
        weekend_duty_Date.removeAll(holiday_tx_date);
        List<DateWithEmp> weekend_morning_dutyed_list=DateAndEmpAdapter(weekend_duty_Date,weekend_morning_duty_emp);//日期与人员匹配
        dutyedEmplist=extractDutyedEmpList(thursday_duty_list,dutyedEmplist);//获取已经被排班的人员
        setDutyRemark(weekend_morning_dutyed_list,DutyRules.周末白班.getStatusCode());
        putToQueueFoot(weekend_morning_dutyed_list);
        /*
        5 普通晚班
         */
//        dutyedEmplist=extractDutyedEmpList(weekend_morning_dutyed_list,dutyedEmplist);//获取已经被排班的人员
        List<Date> common_day_date=getWeekList(need_duty_date,DutyDays.COMMON_DUTY_DAY);
        List<Employee> common_duty_emp=dutyQueueMapper.selectQueueToEmployee(DutyRules.普通晚班.getStatusCode());
        //System.out.println("普通晚班人员队列"+common_duty_emp);
        common_duty_emp.removeAll(HolidayDutyedEmpList);
        List<DateWithEmp> common_duty_list=DateAndEmpAdapter(common_day_date,common_duty_emp);
        setDutyRemark(common_duty_list,DutyRules.普通晚班.getStatusCode());
        putToQueueFoot(common_duty_list);
        putToQueueFoot(holiday_dateWithEmpList);

        //填充总表
        dateWithEmpList.addAll(special_dateWithEmpList);
        dateWithEmpList.addAll(holiday_dateWithEmpList);
        dateWithEmpList.addAll(thursday_duty_list);
        dateWithEmpList.addAll(weekend_morning_dutyed_list);
        dateWithEmpList.addAll(common_duty_list);

       // System.out.println(dateWithEmpList);
        //生成临时排班表
        generateTempDutyResultList(dateWithEmpList);
        return dateWithEmpList;

    }

    /**
     * 移除掉已排班的人
     * @param thursday_duty_emp  要移除员工的集合
     * @param dutyedEmplist  需要移除的员工
     * @return
     */
    private List<Employee> removeDutyedEmp(List<Employee> thursday_duty_emp, List<Employee> dutyedEmplist) {
        List<Employee> employees=new ArrayList<>();
        return thursday_duty_emp;
    }


    private DateWithEmp DateAndEmpAdapterForSpecialDuty(Date beginDate, Employee employee) {
        DateWithEmp dateWithEmp=new DateWithEmp(beginDate,employee);
        return dateWithEmp;
    }

    /**
     * 特殊情况排班函数,目前是写死的，动态操作日后添加
     * 目前只有吴琼一人是特殊值班
     * @param need_duty_date
     * @param beginDate
     */
    public List<DateWithEmp> specialDuty(List<Date> need_duty_date, Date beginDate,Date endDate,List<DateWithEmp> special_dateWithEmpList){
        Employee employee=new Employee();
        employee.setId(44);
        employee.setName("吴琼");
        employee.setRemarks(String.valueOf(DutyRules.特殊值班.getStatusCode()));
        DateWithEmp dateWithEmp;
        if(need_duty_date.contains(beginDate)){
            dateWithEmp=DateAndEmpAdapterForSpecialDuty(beginDate,employee);
            special_dateWithEmpList.add(dateWithEmp);
        }else {
            dateWithEmp=DateAndEmpAdapterForSpecialDuty(endDate,employee);
            special_dateWithEmpList.add(dateWithEmp);
        }
        return special_dateWithEmpList;
    }


    /**
     * 节假日的自动排班函数
     * 节假日的排班日，每日需要早晚班各一人
     * 节假日排班不分周四晚班和周末白班
     * 节假日排班（主要是春节，国庆）时，需要尽可能的避免今年节假日排过班的人再次被排到，具体规则如下：
     * 1.排过一次权重为5以上的班后，今年内将不会再排到权重为5以上的班（包括次年春节）
     */
    public List<DateWithEmp> auto_holiday_duty(List<Date> dateList,List<Employee> dutyed_emp_list,Date beginDate){
        List<DateWithEmp> holidays_duty_list=new ArrayList<>();
        //获取上一个月份
        Integer last_year = beginDate.getYear() + 1900;
        Integer last_month = beginDate.getMonth() + 1;
        //上一个大型节假日已排班人员
//        List<Employee> last_holidays_dutyed_empList=employeeMapper.selectFromFormalDutyByDutyTypeId(last_year,last_month,new int[]{DutyRules.假日白班.getStatusCode(),DutyRules.假日晚班.getStatusCode()});
        List<Employee> bigHolidyDutyed_empList=new ArrayList<>();
        bigHolidyDutyed_empList=dutyQueueMapper.selectBigHolidayDutyedEmp();



        /*
        假期白班
         */
        List<Employee> holidays_morning_duty_emp=dutyQueueMapper.selectQueueToEmployee(DutyRules.假日白班.getStatusCode());//查询出假日白班的排班人员
//        holidays_morning_duty_emp.removeAll(bigHolidyDutyed_empList);
//        holidays_morning_duty_emp.addAll(bigHolidyDutyed_empList);//将大型节假日已排班的人移动集合末尾
        List<DateWithEmp> holidays_morning_dutyList=DateAndEmpAdapter(dateList,holidays_morning_duty_emp);  //适配员工与日期
        setDutyRemark(holidays_morning_dutyList,DutyRules.假日白班.getStatusCode()); //给值班人员打上标记，标注是<白班>还是<晚班>
        /*
        假期晚班
         */
        List<Employee> holidays_evening_duty_emp=dutyQueueMapper.selectQueueToEmployee(DutyRules.假日晚班.getStatusCode());//查询出假日晚班的排班人员
        //holidays_evening_duty_emp.removeAll(last_holidays_dutyed_empList);
        dutyed_emp_list=extractDutyedEmpList(holidays_morning_dutyList,dutyed_emp_list);//获取已经被排班的人员
     //   System.out.println("白班人数为"+dutyed_emp_list.size()+"人为"+dutyed_emp_list);
//        holidays_evening_duty_emp.removeAll(bigHolidyDutyed_empList);
//        holidays_evening_duty_emp.addAll(bigHolidyDutyed_empList);//将大型节假日已排班的人移动集合末尾
        holidays_evening_duty_emp.removeAll(dutyed_emp_list);
        holidays_evening_duty_emp.addAll(dutyed_emp_list);//将已排班的人移动到集合的末尾

        System.out.println("假期晚班队列"+holidays_morning_duty_emp);
        List<DateWithEmp> holidays_evening_dutyList=DateAndEmpAdapter(dateList,holidays_evening_duty_emp);
        setDutyRemark(holidays_evening_dutyList,DutyRules.假日晚班.getStatusCode());
        dutyed_emp_list=extractDutyedEmpList(holidays_evening_dutyList,dutyed_emp_list);
      //  System.out.println("晚班人数为"+dutyed_emp_list.size()+"人为"+dutyed_emp_list);
        holidays_duty_list.addAll(holidays_morning_dutyList);
        holidays_duty_list.addAll(holidays_evening_dutyList);

        return holidays_duty_list;

    }

    /**
     * 在数据库中生成临时排班数据表
     * @param holidays_duty_list
     */
    private void generateTempDutyResultList(List<DateWithEmp> holidays_duty_list) {
        List<TempDutyResult> tempDutyResultList=new ArrayList<>();
        TempDutyResult tempDutyResult;
        for(DateWithEmp dateWithEmp:holidays_duty_list){
            tempDutyResult=new TempDutyResult();
            tempDutyResult.setDutyDate(dateWithEmp.getDutyDate());
            tempDutyResult.setEmpId(dateWithEmp.getEmployee().getId());
            tempDutyResult.setEmpName(dateWithEmp.getEmployee().getName());
            tempDutyResult.setDutyTypeId(Integer.parseInt(dateWithEmp.getEmployee().getRemarks()));
            tempDutyResultList.add(tempDutyResult);
        }
        tempDutyResultMapper.deleteFromTempDutyResult();
        tempDutyResultMapper.insertTempDutyResult(tempDutyResultList);
    }

    /**
     * 用来筛选出已经排班的人
     * @param holidays_morning_dutyList
     * @return
     */
    private List<Employee> extractDutyedEmpList(List<DateWithEmp> holidays_morning_dutyList,List<Employee> dutyed_emp_list) {
        for(DateWithEmp dateWithEmp:holidays_morning_dutyList){
            dutyed_emp_list.add(dateWithEmp.getEmployee());
        }
        return dutyed_emp_list;
    }

    /**
     * 将已经排班的人放到队列的末尾
     * @param holidays_morning_dutyList
     */
    private void putToQueueFoot(List<DateWithEmp> holidays_morning_dutyList) {
        for(DateWithEmp dateWithEmp:holidays_morning_dutyList){
            dutyQueueMapper.deleteByEmpId(dateWithEmp.getEmployee().getId());//先删除
            DutyQueue dutyQueue=new DutyQueue(dateWithEmp.getEmployee().getId(),dateWithEmp.getEmployee().getName());
            dutyQueueMapper.insert(dutyQueue);//再插入
        }
    }


    /**
     * 给值班设置标记
     * @param holidays_morning_dutyList
     * @param dutyRules
     */
    private void setDutyRemark(List<DateWithEmp> holidays_morning_dutyList, int dutyRules) {
        for(DateWithEmp dateWithEmp:holidays_morning_dutyList){
            dateWithEmp.getEmployee().setRemarks(String.valueOf(dutyRules));
        }
    }

    /**
     * 日期与人员适配器
     * 可能存在情况：1.待排班日期>=待排班人员  2.待排班人员>待排班日期
     */
    private List<DateWithEmp> DateAndEmpAdapter(List<Date> dateList, List<Employee>  duty_employeeList) {
        List<DateWithEmp> dateWithEmpList=new ArrayList<>();
        int dateSize=dateList.size();
        int empSize=dateList.size();
        for(int i=0;i<dateSize;i++){
            DateWithEmp dateWithEmp;
            dateWithEmp=i>=empSize?new DateWithEmp(dateList.get(i),duty_employeeList.get(i-duty_employeeList.size())):new DateWithEmp(dateList.get(i),duty_employeeList.get(i));
            dateWithEmpList.add(dateWithEmp);
        }
        return dateWithEmpList;
    }

    /*
    获取星期的集合
    参数为多个日期
    */
    public List<Date> getWeekList(List<Date> dutyDays,List<Integer> day_week){
        List<Date> date_weeks=new ArrayList<>();
        for(Date date:dutyDays){
            int tempDate=DutyUtils.getDatesWeek(date);
            if(day_week.contains(tempDate)){
                date_weeks.add(date);
            }
        }
        return date_weeks;
    }

    /*
    获取星期的集合
    参数为单个日期
     */
    public List<Date> getWeekList(List<Date> dutyDays,int day_week){
        List<Date> date_weeks=new ArrayList<>();
        for(Date date:dutyDays){
            if(DutyUtils.getDatesWeek(date) == day_week){
                date_weeks.add(date);
            }
        }
        return date_weeks;
    }


    /**
     * 为排班生成excel表
     * @param dateWithEmps
     */
    @Override
    public void GenerateExcelTableForDuty(List<DateWithEmp> dateWithEmps) {

    }

    /**
     * 获取用于填充前端日历的数据格式
     * @return
     */
    @Override
    public List<SimpleDateWithEmp> getDutyResultBySimpleFormat() {
        List<Integer> eve_duty=new ArrayList<>(Arrays.asList(3,5,8,9,11));
        List<Integer> mor_duty=new ArrayList<>(Arrays.asList(2,4));
        List<TempDutyResult> tempDutyResults=tempDutyResultMapper.selectList(new QueryWrapper<TempDutyResult>().orderByAsc("dutyDate"));
        for(TempDutyResult tempDutyResult:tempDutyResults){
            int dutyTypeId=tempDutyResult.getDutyTypeId();
            String name=tempDutyResult.getEmpName();
            if(eve_duty.contains(dutyTypeId)){
                tempDutyResult.setEmpName(name+"<晚班>");
            }else {
                tempDutyResult.setEmpName(name+"<白班>");
            }
        }
        List<SimpleDateWithEmp> simpleDateWithEmps=bindSameDutyDayEmp(DutyUtils.TempDutychangeToSimpleFormat(tempDutyResults));
        return simpleDateWithEmps;
    }


    /**
     * 执行正式排班，将排班数据录入历史库
     * 1.临时排班表转为正式排班表
     * 2.删除正式对列表中的旧队列
     * 3.插入当前的新队列（新队列的序号从1开始）
     * @return
     */
    @Override
    public ResultMsg executeFormalDutyResult() {
        tempDutyResultMapper.insertToFormalDutyResult();
        dutyQueueMapper.clearFormalQueue();
        dutyQueueMapper.truncateTable();//清理主键序列
        dutyQueueMapper.insertToFormalQueue();
        return ResultMsg.createBySuccess();
    }


    @Override
    public ResultMsg addNewDutyInfo(TempDutyResult tempDutyResult) {
        tempDutyResultMapper.insert(tempDutyResult);
        return ResultMsg.createBySuccess();
    }


    /*
  将相同日期值班表的人绑定在同一天，例:2019-12-1:张三，2019-12-1：李四（白班）==> 2019-12-1：张三，李四（白班）
   */
    public List<SimpleDateWithEmp> bindSameDutyDayEmp(List<SimpleDateWithEmp> simpleDateWithEmps){
        List<SimpleDateWithEmp> new_SimpleDateWithEmp=new ArrayList<>();
        simpleDateWithEmps.parallelStream().collect(Collectors.groupingBy(o -> (o.getDate()),Collectors.toList())).forEach(
                (id, transfer) -> {
                    transfer.stream().reduce((a, b) -> new SimpleDateWithEmp(a.getDate(),a.getName()+","+b.getName())).ifPresent(new_SimpleDateWithEmp::add);
                });
        return new_SimpleDateWithEmp;
    }


}
