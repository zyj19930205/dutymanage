package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyQueueMapper extends BaseMapper<DutyQueue> {
    void updateRowId(int rowId,int empId);
    int selectRowIdByEmpId(int empId);
    List<Employee> selectQueueToEmployeeByArray(int dutyTypeId[]);
    List<Employee> selectQueueToEmployee(int dutyTypeId);
    void deleteByEmpId(int empId);
    void updateEmpNameAndEmpId(int empId2,String empName2,int rowId);
    void clearFormalQueue();
    void insertToFormalQueue();
}
