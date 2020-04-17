package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.*;
import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.mapper.HolidayMapper;
import cn.jx.chinunicom.dutymanage.service.FormalDutyResultService;
import cn.jx.chinunicom.dutymanage.service.TempDutyResultService;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DutyController {

    @Autowired
    private TempDutyResultService tempDutyResultService;
    @Autowired
    private FormalDutyResultService formalDutyResultService;
    @Autowired
    HolidayMapper holidayMapper;



    @RequestMapping("/getDutyResultForTest")
    public List<DateWithEmp> getDutyResultForTest() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String begin="2020-06-01";
        String end="2020-06-30";
        Date begin_date=sdf.parse(begin);
        Date end_date=sdf.parse(end);
        return tempDutyResultService.autoDutyByDay(begin_date,end_date);
    }

    /**
     * 获取临时排班结果
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/getTempDutyResult")
    public ResultMsg<TempDutyResult> getTempDutyResult(@RequestParam(defaultValue ="15")int limit, @RequestParam (defaultValue = "1") int page){
        ResultMsg resultMsg=tempDutyResultService.getTempDutyResultByPage(page,limit);
        return resultMsg;
    }

    /**
     * 分页查询排班历史结果
     */
    @GetMapping("/getFormalDutyByPage")
    public ResultMsg<FormalDutyResult> getFormalDutyByPage(@RequestParam(defaultValue ="15")int limit, @RequestParam (defaultValue = "1") int page){
        ResultMsg resultMsg=formalDutyResultService.getFormalDutyResultByPage(page,limit);
        return resultMsg;
    }

    /*
    判断要替换的排班日期是否存在
     */
    @RequestMapping("/isDutyDateExist")
    public boolean isDutyDateExist(HttpServletRequest request) throws ParseException {
        Date dutyDate= DutyUtils.StringToDate(request.getParameter("dutyDate"));
        return tempDutyResultService.isDutyDateExist(dutyDate);
    }


    /**
     * 对临时的排班结果进行调整
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/modifyTempDutyResult")
    public ResultMsg modifyTempDutyResult(HttpServletRequest request) throws ParseException {
        Date dutyDate= DutyUtils.StringToDate(request.getParameter("dutyDate"));
        int id=Integer.parseInt(request.getParameter("id"));
        return tempDutyResultService.updateTempDutyResult(id,dutyDate);
    }

    /*
    在临时排班结果中查找是否存在指定的人员名
     */
    @RequestMapping("/getEmpNameInDutyList/{user_name}")
    public String  getEmpNameInDutyList(@PathVariable String user_name){
        List<TempDutyResult> tempDutyResults=tempDutyResultService.findDutyByUserName(user_name);
        if(tempDutyResults!=null && tempDutyResults.size()!=0){
            return "success";
        }
        return "no_such_name";
    }


    /*
    根据人名查询其对应的值班日期，值班日期可能有多个
     */
    @RequestMapping("/getDutyDateByEmpName/{empName}")
    public List<Date> getDutyDateByEmpName(@PathVariable String empName){
        return tempDutyResultService.findDateByEmpName(empName);
    }



//    @RequestMapping("/getHolidayTempDutyList")
//    public List<SimpleDateWithEmp> getHolidayTempDutyList() throws ParseException {
//        String begin="2020-01-01";
//        String end="2020-01-31";
//        Date begin_date=DutyUtils.StringToDate(begin);
//        Date end_date=DutyUtils.StringToDate(end);
//        return DutyUtils.changeToSimpleFormat(tempDutyResultService.autoDutyByDay(begin_date,end_date));
//    }


    /*
    将两个人员之间的排班日期进行调换
     */
    @RequestMapping("/replaceEmpDutyResult")
    public ResultMsg replaceEmpDutyResult(HttpServletRequest request) throws ParseException {
        String empName_1=request.getParameter("empName1");
        String empName_2=request.getParameter("empName2");
        String date_1=request.getParameter("dutyDate1");
        String date_2=request.getParameter("dutyDate2");
        Date new_date_1=DutyUtils.StringToDate(date_1);
        Date new_date_2=DutyUtils.StringToDate(date_2);
        return tempDutyResultService.changeDutyWithTwoEmp(empName_1,empName_2,new_date_1,new_date_2);
    }



    /*
    获取{2020}年的所有节假日
     */
    @RequestMapping("/getHolidays")
    public ResultMsg getHolidays(){
        QueryWrapper<Holiday> holidayQueryWrapper=new QueryWrapper<>();
        holidayQueryWrapper.eq("year(holidayDate)",2020);
        List<Holiday> holidays=holidayMapper.selectList(holidayQueryWrapper);
        System.out.println(holidays);
        return ResultMsg.createBySuccess(holidays.size(),holidays);
    }

    /**
     * 自动排班
     * @param beginDate
     * @param endDate
     * @return
     */
    @RequestMapping("/autoSetDuty/{beginDate}/{endDate}")
    public ResultMsg autoSetDuty(@PathVariable Date beginDate,@PathVariable Date endDate){
        System.out.println(beginDate);
        System.out.println(endDate);
        return ResultMsg.createByFail();
    }

    /**
     * 在日历中查看排班结果
     */
    @RequestMapping("/showResultInCalendar")
    public Map<String,String> showResultInCalendar(){
        Map<String,String> dutyCalendar=new HashMap<>();
        List<SimpleDateWithEmp> simpleDateWithEmps=tempDutyResultService.getDutyResultBySimpleFormat();
        for(SimpleDateWithEmp simpleDateWithEmp:simpleDateWithEmps){
            dutyCalendar.put(simpleDateWithEmp.getDate(),simpleDateWithEmp.getName());
        }
        return dutyCalendar;
    }

    /**
     * 执行排班计划，将临时排班结果转换为正式排班结果，统计入库
     */
    @RequestMapping("/executeFormalDutyPlan")
    public String executeFormalDutyPlan(){
        tempDutyResultService.executeFormalDutyResult();
        return "success";
    }

    /**
     * 查询排班历史结果
     */
    @GetMapping("/getDutyHistory")
    public List<FormalDutyResult> getDutyHistory(){
        return formalDutyResultService.getFormalDutyResult();
    }





    /**
     * 添加一条排班信息
     */
    @RequestMapping("/addNewDutyInfo")
    public ResultMsg addNewDutyInfo(TempDutyResult tempDutyResult){
        return tempDutyResultService.addNewDutyInfo(tempDutyResult);
    }
}
