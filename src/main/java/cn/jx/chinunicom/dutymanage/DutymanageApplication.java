package cn.jx.chinunicom.dutymanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.jx.chinunicom.dutymanage.mapper")
public class DutymanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DutymanageApplication.class, args);
    }

}
