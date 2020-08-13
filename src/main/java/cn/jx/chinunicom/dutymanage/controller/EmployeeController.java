package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.Bo.EmployeeDutyInfo;
import cn.jx.chinunicom.dutymanage.entity.Employee;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.mapper.EmployeeMapper;
import cn.jx.chinunicom.dutymanage.service.EmployeeService;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    /**
    查询所有员工数据
     */
    @RequestMapping("/getEmployee")
    public ResultMsg getEmployeeList(){
        System.out.println("有人试图访问这个接口");
       List<Employee> employeeList=employeeService.findAllEmployee();
       return employeeList.size()>0?ResultMsg.createBySuccess(employeeList.size(),employeeList):ResultMsg.createByNull(employeeList.size(),"无数据");
    }

    /*
    分页查询员工数据
     */
    @RequestMapping("/getEmployeeByPage")
    public ResultMsg<Employee> getEmployeeByPage(@RequestParam(defaultValue ="15")int limit, @RequestParam (defaultValue = "1") int page){
        ResultMsg resultMsg=employeeService.getEmpByPage(page,limit);
        return resultMsg;
    }

    /*
    修改员工信息
     */
    @RequestMapping(value = "/modifyEmployee", method = RequestMethod.PUT)
    public String modifyEmp(HttpServletRequest request){
        String dutyType=request.getParameter("dutyType");
        System.out.println("dutyType is "+dutyType);
        String temp[]=dutyType.split(",");
        int dutyType_list[]= DutyUtils.StringToInt(temp);
        int empId=Integer.parseInt(request.getParameter("id"));
        if(employeeMapper.selectEmpDutyRuleByEmpId(empId)!=null){
            employeeMapper.deleteEmpDutyRuleByEmpId(empId);
        }
        employeeMapper.updateEmpDutyRule(dutyType_list,empId);
        return "更新成功！";
    }


    @RequestMapping(value = "addEmp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
        System.out.println(employee);
        try{
            employeeMapper.insert(employee);
            return "添加员工"+employee.getName()+"成功！";
        }catch (Exception e){
            return "添加失败！";
        }
    }

    @RequestMapping(value = "delEmp/{id}",method = RequestMethod.DELETE)
    public String delEmp(@PathVariable int id){
        employeeMapper.deleteById(id);
        return "删除成功！";
    }

    @RequestMapping(value = "emp/{name}",method = RequestMethod.GET)
    public ResultMsg getEmpByName(@PathVariable String name){
        List<EmployeeDutyInfo> employeeDutyInfos=employeeMapper.selectByEmpName(name);
        return ResultMsg.createBySuccess(employeeDutyInfos.size(),employeeDutyInfos);
    }

}
