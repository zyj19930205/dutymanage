package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("jxlt_formal_duty_result")
public class FormalDutyResult {
    private int id;
    @TableField("empId")
    private int empId;
    @TableField("dutyDate")
    private Date dutyDate;
    @TableField("empName")
    private String empName;
    @TableField("dutyTypeId")
    private int dutyTypeId;
    @TableField(exist = false)
    private String typeName;
}
