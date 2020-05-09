package cn.jx.chinunicom.dutymanage.service.impl;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.mapper.DutyQueueMapper;
import cn.jx.chinunicom.dutymanage.service.QueueService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    DutyQueueMapper dutyQueueMapper;

    @Override
    public ResultMsg getQueueByPage(int page, int limit) {
        Page<DutyQueue> dutyQueuePage=new Page<>(page,limit);
        IPage<DutyQueue> iPage=dutyQueueMapper.selectQueueByPage(dutyQueuePage);
        ResultMsg resultMsg=ResultMsg.createBySuccess(iPage.getTotal(),iPage.getRecords());
        return resultMsg;
    }
}
