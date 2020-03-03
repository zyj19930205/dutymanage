package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.SpecialDuty;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialDutyMapper extends BaseMapper<SpecialDuty> {
    List<SpecialDuty> selectSpecialRuleEmp();
}
