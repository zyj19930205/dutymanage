package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    List<Employee> selectBigHolidayDutyedEmp();
    void truncateTable();

    IPage<DutyQueue> selectQueueByPage(Page<DutyQueue> dutyQueuePage);

    /**
     * 查询上个月值过白班的员工名单
     * @param
     * @return
     */
    List<Employee> selectLastMonthWeekendMorningEmp(String dutyDate);
    void truncateEmpQueue();
    void copyFormalQueueToTemp();

}
