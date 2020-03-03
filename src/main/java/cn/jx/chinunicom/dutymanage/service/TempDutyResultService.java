package cn.jx.chinunicom.dutymanage.service;

import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface TempDutyResultService {
    List<TempDutyResult> getTempDutyResult();
    ResultMsg getTempDutyResultByPage(int page,int limit);
    boolean isDutyDateExist(Date dutyDate);
    ResultMsg updateTempDutyResult(int id,Date date);
    ResultMsg changeDutyWithTwoEmp(String empName1,String empName2,Date date1,Date date2);
    List<TempDutyResult> findDutyByUserName(String username);
    List<Date> findDateByEmpName(String empName);
    List<DateWithEmp> autoDutyByDay(Date beginDate, Date endDate) throws ParseException;
//    void auto_holiday_duty(List<Date> dateList);
    void GenerateExcelTableForDuty(List<DateWithEmp> dateWithEmps);
    List<SimpleDateWithEmp> getDutyResultBySimpleFormat();
    ResultMsg executeFormalDutyResult();

    ResultMsg addNewDutyInfo(TempDutyResult tempDutyResult);


}
