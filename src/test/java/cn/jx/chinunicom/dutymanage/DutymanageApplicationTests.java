package cn.jx.chinunicom.dutymanage;

import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Employee;
import cn.jx.chinunicom.dutymanage.entity.SpecialDuty;
import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import cn.jx.chinunicom.dutymanage.mapper.*;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import cn.jx.chinunicom.dutymanage.service.FormalDutyResultService;
import cn.jx.chinunicom.dutymanage.service.TempDutyResultService;
import cn.jx.chinunicom.dutymanage.util.DutyRules;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DutymanageApplicationTests {
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
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
    @Autowired
    DutyQueueMapper dutyQueueMapper;
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
}
