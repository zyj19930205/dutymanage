package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("jxlt_emp_dutyrule")
public class EmpDutyRule {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("empId")
    private Integer empId;
    @TableField("dutyTypeId")
    private Integer dutyTypeId;
}
