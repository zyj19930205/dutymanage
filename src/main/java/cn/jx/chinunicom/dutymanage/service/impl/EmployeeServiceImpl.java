package cn.jx.chinunicom.dutymanage.service.impl;

import cn.jx.chinunicom.dutymanage.entity.Employee;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.mapper.EmployeeMapper;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeMapper.selectList(null);
    }

    @Override
    public ResultMsg getEmpByPage(int page, int limit) {
        Page<Employee> employeePage=new Page<>(page,limit);
        IPage<Employee> iPage=employeeMapper.selectEmpByPage(employeePage);
        ResultMsg resultMsg=ResultMsg.createBySuccess(iPage.getTotal(),iPage.getRecords());
        return resultMsg;
    }

    /*
    统计部门人数
     */
    @Override
    public Integer getEmpCount() {
        return employeeMapper.selectCount(null);
    }



}
