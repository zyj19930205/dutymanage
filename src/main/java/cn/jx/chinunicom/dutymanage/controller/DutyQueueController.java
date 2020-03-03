package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.mapper.DutyQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Queue;

@RestController
public class DutyQueueController {

    @Autowired
    private DutyQueueMapper dutyQueueMapper;

    @GetMapping("getDutyQueue")
    public List<DutyQueue> getDutyQueue(){
        return dutyQueueMapper.selectList(null);
    }
}
