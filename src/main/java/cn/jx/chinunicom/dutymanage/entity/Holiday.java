package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("jxlt_holidays")
public class Holiday {

    private int id;
    @TableField("holidayName")
    private String holidayName;
    @TableField("holidayDate")
    private Date holidayDate;
}
