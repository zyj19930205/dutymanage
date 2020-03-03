package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("jxlt_special_duty")
public class SpecialDuty {
    private int id;
    @TableField("empId")
    private int empId;
    @TableField("special_remark")
    private String specialRemark;
    @TableField("special_duty_day")
    private int specialDutyDay;
    @TableField("special_duty_time")
    private String specialDutyTime;
    @TableField(value = "special_duty_days",exist = false)
    private String special_duty_days;
}
