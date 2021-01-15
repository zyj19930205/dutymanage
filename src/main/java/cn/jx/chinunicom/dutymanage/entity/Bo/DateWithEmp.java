package cn.jx.chinunicom.dutymanage.entity.Bo;

import cn.jx.chinunicom.dutymanage.entity.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class DateWithEmp {
    private Employee employee;
    private Date dutyDate;
    private String strDate;

    public DateWithEmp( Date dutyDate,Employee employee) {
        this.employee = employee;
        this.dutyDate = dutyDate;
    }
}
