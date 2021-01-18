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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Date beginDate = DutyUtils.StringToDate("2021-02-01");
        Date endDate = DutyUtils.StringToDate("2021-02-28");
        List<Date> holiday_tx_date=holidayMapper.getHolidayByTypeAndYear(7,"2021");//获取调休日
        //获取值班队列
        List<DutyQueue> dutyQueueList=dutyQueueMapper.getFormalDutyQueue();
        System.out.println("初始队列为"+dutyQueueList);
        //值假日班的队列中，应当剔除 去年春节排班人员 今年国庆排班人员
        List<Employee> bigHolidayEmp_festival = dutyQueueMapper.getBigHolidayEmpList(1,"2020");
        List<Employee> bigHolidayEmp_national = dutyQueueMapper.getBigHolidayEmpList(5,"2020");
//        removeDutyedEmp(dutyQueueList,bigHolidayEmp_festival);
//        removeDutyedEmp(dutyQueueList,bigHolidayEmp_national);
        System.out.println("size is" + dutyQueueList.size() + "," + dutyQueueList);
        for(Employee employee:bigHolidayEmp_national){
            dutyQueueList = putEmpToEndQueue(dutyQueueList,employee);
        }
        System.out.println("剔除国庆值班人员后" + dutyQueueList);
        for(Employee employee:bigHolidayEmp_festival){
            dutyQueueList = putEmpToEndQueue(dutyQueueList,employee);
        }
        System.out.println("剔除春节值班人员后" + dutyQueueList);


        //排班顺序：假日班-周末白班-周末晚班-普通晚班
        //检查当月是否存在节假日
        List<Date> need_duty_date= DutyUtils.getDates(beginDate,endDate);//获取要排班的日期列表
        List<Date> holiday_date=holidayMapper.getHoliday_in_dutyScope(beginDate,endDate);//获取当月的节假日
        holiday_date.removeAll(holiday_tx_date);//移除调休日
        List<DateWithEmp> total_dateWithEmps=new ArrayList<>();
        //假日白班
        List<DateWithEmp> ho_mo_duty_list = setDutyEmp(holiday_date,dutyQueueList,DutyRules.假日白班.getStatusCode());
        System.out.println("假日白班"+ ho_mo_duty_list);
        //假日晚班
        List<DateWithEmp> ho_ev_duty_list = setDutyEmp(holiday_date,dutyQueueList,DutyRules.假日晚班.getStatusCode());
        System.out.println("假日晚班"+ ho_ev_duty_list);
        total_dateWithEmps.addAll(ho_ev_duty_list);
        total_dateWithEmps.addAll(ho_mo_duty_list);
        List<DutyQueue> tempRmoveHolidayQueue=new ArrayList<>();
        //本月排班结束后，应当把当月节假日拍过班的人从队列中移除，不让他们本月值两次班（这种属于极端情况，一般不会发生）
        for(DateWithEmp dateWithEmp:total_dateWithEmps){
            DutyQueue dutyQueue=new DutyQueue(dateWithEmp.getEmployee().getId(),dateWithEmp.getEmployee().getName());
            dutyQueueList.remove(dutyQueue);
            tempRmoveHolidayQueue.add(dutyQueue);
        }



        //周六白班
        need_duty_date.removeAll(holiday_date);
        need_duty_date.removeAll(holiday_tx_date);
//        System.out.println("需要排班的日期为" + need_duty_date);

        List<Date> saturDayList=getWeekList(need_duty_date, DutyDays.SATURDAY.getDay());
        saturDayList.removeAll(holiday_tx_date);
        List<DateWithEmp> sar_mo_duty_list = setDutyEmp(saturDayList,dutyQueueList,DutyRules.周末白班.getStatusCode());
        //周日白班
        List<Date> sundayList=getWeekList(need_duty_date, DutyDays.SUNDAY.getDay());
        sundayList.removeAll(holiday_tx_date);
        List<DateWithEmp> sun_mo_duty_list = setDutyEmp(sundayList,dutyQueueList,DutyRules.周末白班.getStatusCode());
        //普通晚班
        List<Date> common_day_date=getWeekList(need_duty_date,DutyDays.COMMON_DUTY_DAY);
        System.out.println(common_day_date);
        common_day_date.addAll(holiday_tx_date);
        List<DateWithEmp> common_duty_list = setDutyEmp(common_day_date,dutyQueueList,DutyRules.普通晚班.getStatusCode());
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

    /**
     * 返回队列中第一个满足排班条件的员工id
     */
    public Employee getOneEmpForDuty(List<DutyQueue> dutyQueueList,Integer dutyRule){
        for(DutyQueue dutyQueue:dutyQueueList){
            System.out.println(dutyQueue);
            if(checkDutyRules(dutyQueue.getEmpId(),dutyRule)){
                return new Employee(dutyQueue.getEmpId(),dutyQueue.getEmpName(),dutyRule);
            }
            continue;
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

    public void removeDutyedEmp( List<DutyQueue> queueList,List<Employee> employeeList){
        for(Employee employee:employeeList){
            queueList.remove(new DutyQueue(employee.getId(),employee.getName()));
        }
    }
}
