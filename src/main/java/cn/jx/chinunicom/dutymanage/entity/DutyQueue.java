package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/*
排班队列实体类
 */
@Data
@TableName("jxlt_temp_emp_queue")
public class DutyQueue {
    @TableField("rowId")
    private int rowId;
    @TableField("empId")
    private int empId;
    @TableField("empName")
    private String empName;

    public DutyQueue(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }
}
