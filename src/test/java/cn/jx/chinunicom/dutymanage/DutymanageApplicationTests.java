package cn.jx.chinunicom.dutymanage;

import cn.jx.chinunicom.dutymanage.entity.*;
import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.mapper.*;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import cn.jx.chinunicom.dutymanage.service.FormalDutyResultService;
import cn.jx.chinunicom.dutymanage.service.TempDutyResultService;
import cn.jx.chinunicom.dutymanage.service.impl.TempDutyResultImpl;
import cn.jx.chinunicom.dutymanage.util.DutyDays;
import cn.jx.chinunicom.dutymanage.util.DutyRules;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class DutymanageApplicationTests {
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DutyQueueMapper dutyQueueMapper;
    @Autowired
    private HolidayMapper holidayMapper;
    @Autowired
    private EmpDutyRuleMapper empDutyRuleMapper;
    @Autowired
    private TempDutyResultMapper tempDutyResultMapper;
//    @Autowired
//    private TempDutyResultService tempDutyResultService;
//    @Autowired
//    TempDutyResultMapper tempDutyResultMapper;
//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    HolidayMapper holidayMapper;
//    @Autowired
//    SpecialDutyMapper specialDutyMapper;
//    @Autowired
//    DutyQueueMapper dutyQueueMapper;
    @Autowired
    FormalDutyResultService formalDutyResultService;
//    @Autowired
//    DutyQueueMapper dutyQueueMapper;

    private TempDutyResultImpl tempDutyResult;
//
//    private static ApplicationContext applicationContext = null;

    @Test
    void contextLoads() {
        Date date=new Date();
        Integer last_year = date.getYear() + 1900;
        Integer last_month = date.getMonth() + 1;
        System.out.println(last_year+"/"+last_month);
        List<Employee> last_holidays_dutyed_empList=employeeMapper.selectFromFormalDutyByDutyTypeId(last_year,last_month,new int[]{DutyRules.假日白班.getStatusCode(),DutyRules.假日晚班.getStatusCode()});
        System.out.println(last_holidays_dutyed_empList);
    }
//
//    @Test
//    public void getAllEmp(){
//        int aa[]={2,11};
//      List<Employee> employeeList=dutyQueueMapper.selectQueueToEmployeeByArray(aa);
//      System.out.println(employeeList);
//    }
//
//    @Test
//    public void getAllDutyInfo(){
//        List<TempDutyResult> tempDutyResults=tempDutyResultService.getTempDutyResult();
//        System.out.println(tempDutyResults);
//    }
//    @Test
//    public void isDutyExist() throws ParseException {
//        String date="2022-09-10";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date dutyDate=sdf.parse(date);
//        boolean aaa=tempDutyResultService.isDutyDateExist(dutyDate);
//        System.out.println(aaa);
//    }
//
//    @Test
//    public void getUser() throws ParseException {
//        String str_date="2020-01-31";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date date=sdf.parse(str_date);
//      TempDutyResult tempDutyResult=tempDutyResultMapper.selectByDutyDateAndEmpName("吴琼",date);
//      System.out.println(tempDutyResult);
//    }
//
//
//    /**
//     * 用来手动排班的函数
//     * @throws ParseException
//     */
//    @Test
//    public void autoDuty() throws ParseException {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String begin="2020-05-01";
//        String end="2020-05-31";
//        Date begin_date=sdf.parse(begin);
//        Date end_date=sdf.parse(end);
//        List<Date> dates=holidayMapper.getHoliday_in_dutyScope(begin_date,end_date);
//        List<DateWithEmp> dateWithEmpList=tempDutyResultService.autoDutyByDay(begin_date,end_date);
//    }
//
    @Test
    public void generateExcel() throws IOException {
        formalDutyResultService.GenerateExcelTableForDuty();
    }
//
//    @Test
//    public void ahaha(){
//        List<SimpleDateWithEmp> simpleDateWithEmps=tempDutyResultService.getDutyResultBySimpleFormat();
//        System.out.println(simpleDateWithEmps);
//    }
//
    @Test
    public void executeFormalDuty() throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
        String str ="2020-08-01";
        Date date=sdf.parse(str);
        String lastMonthDate = sdf.format(date);
//        System.out.println(lastMonthDate);
        List<Employee> employeeList=dutyQueueMapper.selectLastMonthWeekendMorningEmp(lastMonthDate);
        System.out.println(employeeList);
    }

    @Test
    public void getFormalQueue() throws ParseException {
        Date beginDate = DutyUtils.StringToDate("2021-04-01");
        Date endDate = DutyUtils.StringToDate("2021-04-30");
        //List<Date> holiday_tx_date=holidayMapper.getHolidayByTypeAndYear(7,"2021");//获取调休日
        //获取值班队列
        List<DutyQueue> dutyQueueList=dutyQueueMapper.getFormalDutyQueue();
//        System.out.println("初始队列为"+dutyQueueList);
        //值假日班的队列中，应当剔除 去年春节排班人员 今年国庆排班人员
//        List<Employee> bigHolidayEmp_festival = dutyQueueMapper.getBigHolidayEmpList(1,"2020");
//        List<Employee> bigHolidayEmp_national = dutyQueueMapper.getBigHolidayEmpList(5,"2020");
//        removeDutyedEmp(dutyQueueList,bigHolidayEmp_festival);
//        removeDutyedEmp(dutyQueueList,bigHolidayEmp_national);
//        System.out.println("size is" + dutyQueueList.size() + "," + dutyQueueList);
//        for(Employee employee:bigHolidayEmp_national){
//            dutyQueueList = putEmpToEndQueue(dutyQueueList,employee);
//        }
//        System.out.println("剔除国庆值班人员后" + dutyQueueList);
//        for(Employee employee:bigHolidayEmp_festival){
//            dutyQueueList = putEmpToEndQueue(dutyQueueList,employee);
//        }
//        System.out.println("剔除春节值班人员后" + dutyQueueList);


        //排班顺序：假日班-周末白班-周末晚班-普通晚班
        //检查当月是否存在节假日
        List<Date> need_duty_date= DutyUtils.getDates(beginDate,endDate);//获取要排班的日期列表
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(beginDate,endDate);//获取当月的节假日
//        holiday_date.removeAll(holiday_tx_date);//移除调休日
        List<DateWithEmp> total_dateWithEmps=new ArrayList<>();
        //假日白班
        List<DateWithEmp> ho_mo_duty_list = setDutyEmp(holiday_date,dutyQueueList,DutyRules.假日白班.getStatusCode());
        //假日晚班
        List<DateWithEmp> ho_ev_duty_list = setDutyEmp(holiday_date,dutyQueueList,DutyRules.假日晚班.getStatusCode());
        total_dateWithEmps.addAll(ho_ev_duty_list);
        total_dateWithEmps.addAll(ho_mo_duty_list);
        List<DutyQueue> tempRmoveHolidayQueue=new ArrayList<>();
        //本月排班结束后，应当把当月节假日拍过班的人从队列中移除，不让他们本月值两次班（这种属于极端情况，一般不会发生）
        for(DateWithEmp dateWithEmp:total_dateWithEmps){
            DutyQueue dutyQueue=new DutyQueue(dateWithEmp.getEmployee().getId(),dateWithEmp.getEmployee().getName());
            dutyQueueList.remove(dutyQueue);
            tempRmoveHolidayQueue.add(dutyQueue);
        }

        //周四晚班
        List<Date> thursDayList = getWeekList(need_duty_date,DutyDays.THURSDAY.getDay());
        List<DateWithEmp> thurs_duty_list = setDutyEmp(thursDayList,dutyQueueList,DutyRules.周四晚班.getStatusCode());

        //周六白班
        //先查出上个月周六值过班的人，调整到队列最后方
        List<Employee> employeeList_weekend = dutyQueueMapper.selectLastMonthWeekendMorningEmp("2021-03-25");
        System.out.println("上个月值周末班的人为"+employeeList_weekend);
        //排班前
        need_duty_date.removeAll(holiday_date);
//        need_duty_date.removeAll(holiday_tx_date);
//        System.out.println("需要排班的日期为" + need_duty_date);
        List<Date> saturDayList=getWeekList(need_duty_date, DutyDays.SATURDAY.getDay());
//        saturDayList.removeAll(holiday_tx_date);
        List<DateWithEmp> sar_mo_duty_list = setDutyEmp(saturDayList,dutyQueueList,DutyRules.周末白班.getStatusCode());
        //周日白班
        List<Date> sundayList=getWeekList(need_duty_date, DutyDays.SUNDAY.getDay());
//        sundayList.removeAll(holiday_tx_date);
        List<DateWithEmp> sun_mo_duty_list = setDutyEmp(sundayList,dutyQueueList,DutyRules.周末白班.getStatusCode());
        //普通晚班
        List<Date> common_day_date=getWeekList(need_duty_date,DutyDays.COMMON_DUTY_DAY);
        common_day_date.removeAll(thursDayList);
//        System.out.println(common_day_date);
//        common_day_date.addAll(holiday_tx_date);
        List<DateWithEmp> common_duty_list = setDutyEmp(common_day_date,dutyQueueList,DutyRules.普通晚班.getStatusCode());
        total_dateWithEmps.addAll(thurs_duty_list);
        total_dateWithEmps.addAll(sar_mo_duty_list);
        total_dateWithEmps.addAll(sun_mo_duty_list);
        total_dateWithEmps.addAll(common_duty_list);
        generateTempDutyResultList(total_dateWithEmps);
        System.out.println("移除节假日值班后的人数为"+dutyQueueList.size()+"队列为"+dutyQueueList);
        System.out.println("排班总数"+total_dateWithEmps.size()+"排班结果为"+total_dateWithEmps);
        dutyQueueList.addAll(tempRmoveHolidayQueue);
        generateTempQueue(dutyQueueList);
//        System.out.println("最终队列总人数"+dutyQueueList.size()+"队列为"+dutyQueueList);

    }

    /**
     * 校验员工是否符合排班规则
     * @param empId
     * @return
     */
    public Boolean checkDutyRules(Integer empId,Integer dutyRule){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("empId",empId);
        queryWrapper.eq("dutyTypeId",dutyRule);
        List<EmpDutyRule> empDutyRules=empDutyRuleMapper.selectList(queryWrapper);
        if(empDutyRules.size()==0){
            return false;
        }
        return true;
    }

    Integer candutyMan = 0;
    Set<String> cannotdutyman = new HashSet<>();
    /**
     * 返回队列中第一个满足排班条件的员工id
     */
    public Employee getOneEmpForDuty(List<DutyQueue> dutyQueueList,Integer dutyRule){
        Employee employee;
        for(int i=0;i<dutyQueueList.size();i++){
            if(checkDutyRules(dutyQueueList.get(i).getEmpId(),dutyRule)){
                System.out.println("当前排班人员"+dutyQueueList.get(i).getEmpName()+"，符合排班规则");
                employee=new Employee(dutyQueueList.get(i).getEmpId(),dutyQueueList.get(i).getEmpName(),dutyRule);
                return employee;
            } else {
                cannotdutyman.add(dutyQueueList.get(i).getEmpName());
//                System.out.println("当前排班人员"+dutyQueueList.get(i).getEmpName()+"，不符合排班规则！！");
                continue;
            }
        }
        return null;
    }

    /**
     * 把已排班的员工移动到队列末尾
     * @param dutyQueueList
     * @return
     */
    public List<DutyQueue> putEmpToEndQueue(List<DutyQueue> dutyQueueList,Employee employee){
        DutyQueue tempEmp = new DutyQueue(employee.getId(),employee.getName());
        dutyQueueList.remove(tempEmp);
        dutyQueueList.add(tempEmp);
        return dutyQueueList;
    }

    /**
     * 把已排班的员工移动到队列末尾,批量方法
     * @param dutyQueueList
     * @return
     */
    public List<DutyQueue> putEmpToEndQueue(List<DutyQueue> dutyQueueList,List<Employee> employee){
        DutyQueue tempEmp;
//        List<DutyQueue> dutyQueues=dutyQueueList;
        for(Employee employee1:employee){
            tempEmp=new DutyQueue(employee1.getId(),employee1.getName());
            dutyQueueList.remove(tempEmp);
            dutyQueueList.add(tempEmp);
        }
//        DutyQueue tempEmp = new DutyQueue(employee.getId(),employee.getName());
//        dutyQueueList.remove(tempEmp);
//        dutyQueueList.add(tempEmp);
        return dutyQueueList;
    }


    /**
     * 将值班人员和日期匹配起来
     */
    public List<DateWithEmp> setDutyEmp(List<Date> holiday_date,List<DutyQueue> dutyQueueList,Integer dutyCode){
        DateWithEmp dateWithEmp;
        Employee tempEmp;
        DutyQueue tempQueue;
        List<DateWithEmp> dateWithEmps=new ArrayList<>();
        for(int i=0;i<holiday_date.size();i++){
            //1.先校验该员工是否符合值班规则，若不是，则跳过(换队列里的下一个）。若是，则给予排班
            tempEmp = getOneEmpForDuty(dutyQueueList,dutyCode);
            tempEmp.setRemarks(dutyCode.toString());
            dateWithEmp = new DateWithEmp(holiday_date.get(i), tempEmp);
            dateWithEmp.setStrDate(DutyUtils.DateToStr(holiday_date.get(i)));
            tempQueue = new DutyQueue(tempEmp.getId(),tempEmp.getName());
            dutyQueueList.remove(tempQueue);
            dutyQueueList.add(tempQueue);
            dateWithEmps.add(dateWithEmp);
        }
        return dateWithEmps;
    }



    public List<Date> getWeekList(List<Date> dutyDays,int day_week){
        List<Date> date_weeks=new ArrayList<>();
        for(Date date:dutyDays){
            if(DutyUtils.getDatesWeek(date) == day_week){
                date_weeks.add(date);
            }
        }
        return date_weeks;
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
     * 将新的队列插入到临时队列表中
     */
    public void generateTempQueue(List<DutyQueue> dutyQueueList){
        dutyQueueMapper.truncateEmpQueue();
        for(DutyQueue dutyQueue:dutyQueueList){
            dutyQueueMapper.insert(dutyQueue);
        }
    }

    private void setDutyRemark(List<DateWithEmp> holidays_morning_dutyList, int dutyRules) {
        for(DateWithEmp dateWithEmp:holidays_morning_dutyList){
            dateWithEmp.getEmployee().setRemarks(String.valueOf(dutyRules));
        }
    }

    public List<DutyQueue> removeDutyedEmp( List<DutyQueue> queueList,List<Employee> employeeList){
        List<DutyQueue> tempQueue = new ArrayList<>();
        Integer i = 0;
        for(Employee employee:employeeList){
            tempQueue.add(new DutyQueue(employee.getId(),employee.getName()));
            queueList.remove(new DutyQueue(employee.getId(),employee.getName()));
        }
        return tempQueue;
    }

    /**
     * 意识清晰的情况下编写的排班生成函数：
     * 1.先判断本月有无节假日，若有，则优先排节假日，应当尽可能保证前两个大型节假日（春节，国庆）值过班的同事不会被排班
     * 2.判断本月是否有调休日，若有则将该日设置为普通排班日
     * 3.排周四晚班，周四晚班目前仅限创新应用组的人值班
     * 4.排周末班，上月被排到周末班的人本月应当尽可能不被排到
     * 5.排普通晚班，普通晚班指，除了周末和周四以及节假日以外的所有日期
     */
    @Test
    public void getTempDutyListTable() throws ParseException {
        Date begin = DutyUtils.StringToDate("2021-05-01");
        Date end = DutyUtils.StringToDate("2021-05-31");
        List<DateWithEmp> holiday_duty_list=new ArrayList<>();
        List<DutyQueue> removedQueue_holiday = new ArrayList<>();//存储被移除的队列
        List<Employee> holiday_Emps = new ArrayList<>();
        List<DutyQueue> tempQueue = dutyQueueMapper.getFormalDutyQueue();//获取值班队列
        List<Date> need_duty_date= DutyUtils.getDates(begin,end);//获取排班日期列表
        List<Date> weekend_days = getWeekList(need_duty_date,DutyDays.WEEKEND_DUTY_DAY);//获取这个月的所有周末
        List<Date> common_days = getWeekList(need_duty_date,DutyDays.COMMON_DUTY_DAY_NOT_EXIST_WEEKEND);//获取这个月所有普通班（周一到周五）
//        common_days.removeAll(holiday_date);//从普通班中移除节假日
        System.out.println("——————————————————————————————————————开始排班，总人数为"+tempQueue.size()+"——————————————————————————————————————————");
        //1.获取节假日值班表,并将已排班的人从本月排班计划中移除
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(begin,end);
        common_days.removeAll(holiday_date);
        weekend_days.removeAll(holiday_date);
        if(holiday_date.size()!=0) {
             holiday_duty_list = getHolidayList(begin, end);
            holiday_Emps = getEmpListByDateWithEmp(holiday_duty_list);
            removedQueue_holiday = removeDutyedEmp(tempQueue,holiday_Emps);
            System.out.println("——————————————————————————————————————假日排完以后剩余可用人数为————————————————————————————————————————"+tempQueue.size());
//            tempQueue = putEmpToEndQueue(tempQueue,holiday_Emps);
        }


        //2.获取本月的调休日，并将之从周末班移除,添加进普通排班中
        List<Date> specail_work_date = getSpecialWorkDay(begin,end);
        if(specail_work_date.size()!=0){
            weekend_days.removeAll(specail_work_date);
            common_days.addAll(specail_work_date);
        }

        //3.周四排班
        List<Date> thursday_date =  getWeekList(need_duty_date,DutyDays.THURSDAY.getDay());
        List<DateWithEmp> thursday_Date_withEmp = setDutyEmp(thursday_date,tempQueue,DutyRules.周四晚班.getStatusCode());
        List<Employee> thursDayEmp = getEmpListByDateWithEmp(thursday_Date_withEmp);
        List<DutyQueue> thursDutyQueue =  removeDutyedEmp(tempQueue,thursDayEmp);
        common_days.removeAll(thursday_date);



        //4.双休排班
        System.out.println("*************************************************周末值班开始***********************************************************");
        System.out.println("*************************************************周末值班队列"+tempQueue+"***********************************************************");
        List<DateWithEmp> dateWithEmpList_weekEnd=setWeekendDuty(begin,end,tempQueue,weekend_days,holiday_Emps);
        List<Employee> weekenddutyEmp = getEmpListByDateWithEmp(dateWithEmpList_weekEnd);
        List<DutyQueue> removeQueue_weekend = removeDutyedEmp(tempQueue,weekenddutyEmp);
        System.out.println("——————————————————————————————————————周末排完以后剩余可用人数为————————————————————————————————————————"+tempQueue.size());
        //4.普通日期排班
        System.out.println("*************************************************普通值班开始***********************************************************");
        List<DateWithEmp> dateWithEmpList_common = setCommonDuty(begin,end,tempQueue,common_days);

        List<DateWithEmp> totalDate = new ArrayList<>();
        totalDate.addAll(holiday_duty_list);
        totalDate.addAll(dateWithEmpList_weekEnd);
        totalDate.addAll(dateWithEmpList_common);
        totalDate.addAll(thursday_Date_withEmp);
        generateTempDutyResultList(totalDate);
        tempQueue.addAll(removeQueue_weekend);
        tempQueue.addAll(removedQueue_holiday);
        tempQueue.addAll(thursDutyQueue);
        System.out.println("排完以后队列为" + tempQueue.size());
        generateTempQueue(tempQueue);

    }


    /**
     * no1.排节假日值班表
     */
    @Test
    public void holidayDutyList() throws ParseException {
        //1.获取本月所有节假日
        Date begin = DutyUtils.StringToDate("2021-04-01");
        Date end = DutyUtils.StringToDate("2021-04-30");
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(begin,end);
        //2.获取值班队列
        List<DutyQueue> dutyQueueList=dutyQueueMapper.getFormalDutyQueue();
        //3.生成一个特殊临时队列，将春节和国庆值班的人排到队列最底部，先获取2021年春节和2020年国庆值过班的人

    }


    /**
     * 生成节假日特殊值班队列
     * 这个方法需要每个月修改
     */
    @Test
    public List<DateWithEmp> getHolidayList(Date begin,Date end) throws ParseException {
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(begin,end);
//        List<DutyQueue> dutyQueueList=dutyQueueMapper.getFormalDutyQueue();
        //获取2021年春节值班人员
        List<Employee> employeeList_1=dutyQueueMapper.getBigHolidayEmpList(1,"2021");
        //获取2020年国庆值班人员
        List<Employee> employeeList_2=dutyQueueMapper.getBigHolidayEmpList(5,"2020");
        //获取2021年清明值班人员
        List<Employee> employeeList_3=dutyQueueMapper.getBigHolidayEmpList(4,"2021");
        List<DutyQueue> tempQueue = dutyQueueMapper.getFormalDutyQueue();
        System.out.println("队列总人数为"+tempQueue.size());
        for(Employee employee:employeeList_2){
            putEmpToEndQueue(tempQueue,employee);
        }
        for(Employee employee1:employeeList_1){
            putEmpToEndQueue(tempQueue,employee1);
        }
        for(Employee employee1:employeeList_3){
            putEmpToEndQueue(tempQueue,employee1);
        }
        List<DateWithEmp> dateWithEmpList=setDutyEmp(holiday_date,tempQueue,DutyRules.假日白班.getStatusCode());
        List<DateWithEmp> dateWithEmpList2=setDutyEmp(holiday_date,tempQueue,DutyRules.假日晚班.getStatusCode());
        dateWithEmpList.addAll(dateWithEmpList2);
        return dateWithEmpList;
    }

    /**
     * 获取日期区间内的调休日
     */
    @Test
    public List<Date> getSpecialWorkDay(Date begin,Date end) throws ParseException {
//        Date begin = DutyUtils.StringToDate("2021-04-01");
//        Date end = DutyUtils.StringToDate("2021-04-30");
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("HolidayType",7);
        queryWrapper.between("holidayDate",begin,end);
        List<Holiday> holidays=holidayMapper.selectList(queryWrapper);
        List<Date> dates=new ArrayList<>();
        for(Holiday holiday:holidays){
            dates.add(holiday.getHolidayDate());
        }
       return dates;
    }


    /**
     * 周末班排班
     */
    @Test
    public List<DateWithEmp> setWeekendDuty(Date begin,Date end,List<DutyQueue> tempQueue, List<Date> weekend_days,List<Employee> employeeList) throws ParseException {
//        Date begin1 = DutyUtils.StringToDate("2021-04-01");
//        Date end1 = DutyUtils.StringToDate("2021-04-30");
        List<Date> need_duty_date= DutyUtils.getDates(begin,end);//获取排班日期列表
//        List<Date> weekend_days = getWeekList(need_duty_date,DutyDays.WEEKEND_DUTY_DAY);
        List<Date> saturDayList=getWeekList(weekend_days, DutyDays.SATURDAY.getDay());
        List<Date> sunDayList=getWeekList(weekend_days, DutyDays.SUNDAY.getDay());
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        String myDate = sdf.format(begin);
        //查询出上个月周末值班人员
        List<Employee> employeeList_weekend = dutyQueueMapper.selectLastMonthWeekendMorningEmp(myDate);
        employeeList_weekend.removeAll(employeeList);
        putEmpToEndQueue(tempQueue,employeeList_weekend);
        List<DateWithEmp> dateWithEmpList = setDutyEmp(saturDayList,tempQueue,DutyRules.周六白班.getStatusCode());
        List<DateWithEmp> dateWithEmpList2 = setDutyEmp(saturDayList,tempQueue,DutyRules.周六晚班.getStatusCode());
        List<DateWithEmp> dateWithEmpList3 = setDutyEmp(sunDayList,tempQueue,DutyRules.周日白班.getStatusCode());
        List<DateWithEmp> dateWithEmpList4 = setDutyEmp(sunDayList,tempQueue,DutyRules.周日晚班.getStatusCode());
        dateWithEmpList.addAll(dateWithEmpList2);
        dateWithEmpList.addAll(dateWithEmpList3);
        dateWithEmpList.addAll(dateWithEmpList4);
        for(DateWithEmp dateWithEmp:dateWithEmpList){
            System.out.println("姓名:"+ dateWithEmp.getEmployee().getName()+",日期"+dateWithEmp.getDutyDate());
        }
        return dateWithEmpList;
    }


    /**
     * 普通班排班
     * @return
     */
    public List<DateWithEmp> setCommonDuty(Date begin,Date end,List<DutyQueue> tempQueue,List<Date> common_days) throws ParseException {
        List<Date> need_duty_date= DutyUtils.getDates(begin,end);//获取排班日期列表
        System.out.println("需要排版的普通日期为"+common_days);
        List<DateWithEmp> dateWithEmpList = setDutyEmp(common_days,tempQueue,DutyRules.普通晚班.getStatusCode());
        System.out.println("普通排班开始");
        for(DateWithEmp dateWithEmp:dateWithEmpList){
            System.out.println("姓名:"+ dateWithEmp.getEmployee().getName()+",日期"+dateWithEmp.getDutyDate());
        }
        return dateWithEmpList;
    }

    @Test
    public List<Employee> getEmpListByDateWithEmp(List<DateWithEmp> dateWithEmps){
        List<Employee> employeeList=new ArrayList<>();
        for(DateWithEmp dateWithEmp:dateWithEmps){
            employeeList.add(dateWithEmp.getEmployee());
        }
        return employeeList;
    }
}
