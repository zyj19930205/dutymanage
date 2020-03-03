package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> selectEmpByGender(String gender);
    IPage<Employee> selectEmpByPage(Page<Employee> employeePage);
    List<String> selectEmpDutyRuleByEmpId(int empId);
    void deleteEmpDutyRuleByEmpId(int empId);
    void updateEmpDutyRule(@Param("dutyTypeIdArray") int[] dutyTypeId, int empId);
    List<Employee> selectEmpByDutyRule(int[] dutyTypeId);
    List<Employee> selectFromFormalDutyByDutyTypeId(int[] dutyTypeIds);
}
