package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.FormalDutyResult;
import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface FormalDutyMapper extends BaseMapper<FormalDutyResult> {
    IPage<FormalDutyResult> getFormalDutyResultByPage(Page<FormalDutyResult> formalDutyResultPage);
}
