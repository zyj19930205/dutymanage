package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("jxlt_employee")
public class Employee {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String gender;
    private String address;
    private String remarks;
    @TableField("special_rule")
    private int specialRule;
    @TableField(exist=false)
    private String empDutyTypeIds;
    @TableField(exist=false)
    private Integer dutyId;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }


    public Employee(Integer id, String name, Integer dutyId) {
        this.id = id;
        this.name = name;
        this.dutyId = dutyId;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Employee)) {
            // instanceof 已经处理了obj = null的情况
            return false;
        }
        Employee employee = (Employee) obj;
        // 地址相等
        if (this == employee) {
            return true;
        }
        // 如果两个对象的id相等，则认为是同一个对象
        if (employee.id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }
}
