package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.Employee;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.mapper.EmployeeMapper;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    /*
    查询所有员工数据
     */
    @CrossOrigin(origins = {"http://localhost:8080", "null"})
    @RequestMapping("/getEmployee")
    public ResultMsg getEmployeeList(){
       List<Employee> employeeList=employeeService.findAllEmployee();
       return employeeList.size()>0?ResultMsg.createBySuccess(employeeList.size(),employeeList):ResultMsg.createByNull(employeeList.size(),"无数据");
    }

    /*
    分页查询员工数据
     */
    @CrossOrigin(origins = {"http://localhost:8080", "null"})
    @RequestMapping("/getEmployeeByPage")
    public ResultMsg<Employee> getEmployeeByPage(@RequestParam(defaultValue ="15")int limit, @RequestParam (defaultValue = "1") int page){
        ResultMsg resultMsg=employeeService.getEmpByPage(page,limit);
        return resultMsg;
    }

    /*
    修改员工信息
     */
    @RequestMapping("/modifyEmployee")
    public String modifyEmp(HttpServletRequest request){
        String dutyType=request.getParameter("dutyType");
        String temp[]=dutyType.split(",");
        int dutyType_list[]= DutyUtils.StringToInt(temp);
        int empId=Integer.parseInt(request.getParameter("id"));
        if(employeeMapper.selectEmpDutyRuleByEmpId(empId)!=null){
            employeeMapper.deleteEmpDutyRuleByEmpId(empId);
        }
        employeeMapper.updateEmpDutyRule(dutyType_list,empId);
        return "更新成功！";
    }


}
