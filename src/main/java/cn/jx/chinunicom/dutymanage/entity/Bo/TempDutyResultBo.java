package cn.jx.chinunicom.dutymanage.entity.Bo;

import lombok.Data;

import java.util.Date;

@Data
public class TempDutyResultBo {
    private int id;
    private int empId;
    private String dutyDate;
    private String empName;
    private int dutyTypeId;
    private String typeName;
}
