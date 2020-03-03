package cn.jx.chinunicom.dutymanage.entity.Bo;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleDateWithEmp {
    private String date;
    private String name;

    public SimpleDateWithEmp(String date, String name) {
        this.date = date;
        this.name = name;
    }
}
