package cn.jx.chinunicom.dutymanage.entity.Bo;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDutyInfo {
    private int id;
    private String name;
    private String address;
    private String remarks;
    private String gender;
    private Date dutyDate;
    private int dutyTypeId;
    private String typeName;
}
