package cn.jx.chinunicom.dutymanage.service;

import cn.jx.chinunicom.dutymanage.entity.Employee;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();

    ResultMsg getEmpByPage(int page, int limit);

    Integer getEmpCount();

}
