package cn.jx.chinunicom.dutymanage.service;

import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.FormalDutyResult;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;

import java.io.IOException;
import java.util.List;

public interface FormalDutyResultService {
    void GenerateExcelTableForDuty() throws IOException;

    List<FormalDutyResult> getFormalDutyResult();

    ResultMsg getFormalDutyResultByPage(int page, int limit);
}
