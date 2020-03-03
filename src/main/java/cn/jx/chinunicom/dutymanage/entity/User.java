package cn.jx.chinunicom.dutymanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("jxlt_user")
@Data
public class User {
    private int userId;
    private int empId;
    private String username;
    private String password;
    private int userType;
    private Employee employee;
}
