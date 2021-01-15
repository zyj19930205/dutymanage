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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DutyQueue)) {
            // instanceof 已经处理了obj = null的情况
            return false;
        }
        DutyQueue dutyQueue = (DutyQueue) obj;
        // 地址相等
        if (this == dutyQueue) {
            return true;
        }
        // 如果两个对象的id相等，则认为是同一个对象
        if (dutyQueue.empId == this.empId) {
            return true;
        } else {
            return false;
        }
    }
}
