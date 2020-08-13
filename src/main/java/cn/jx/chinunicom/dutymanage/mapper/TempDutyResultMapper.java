package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TempDutyResultMapper extends BaseMapper<TempDutyResult> {
    IPage<TempDutyResult> getTempDutyResultByPage(Page<TempDutyResult> tempDutyResultPage);
    void updateDutyDateByEmpId(int id, Date dutyDate);
    TempDutyResult selectTempDutyResultByDutyDate(Date dutyDate);
    void deleteFromTempDutyResult();
    void insertTempDutyResult(List<TempDutyResult> tempDutyResults);
    void deleteByEmpId(int empId);
    void insertEmployee(int empId,String empName);

    void updateDutyById(int empId2,String empName2,int id);
    TempDutyResult selectByDutyDateAndEmpName(String empName,Date dutyDate);
    void insertToFormalDutyResult();

}
