package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.mapper.DutyQueueMapper;
import cn.jx.chinunicom.dutymanage.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RestController
public class DutyQueueController {

    @Autowired
    private DutyQueueMapper dutyQueueMapper;
    @Autowired
    private QueueService queueService;

    @GetMapping("/getDutyQueue")
    public ResultMsg getDutyQueue(){
        List<DutyQueue> dutyQueues=dutyQueueMapper.selectList(null);
        return ResultMsg.createBySuccess(dutyQueues.size(),dutyQueues);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getDutyQueueByPage")
    public ResultMsg getDutyQueueByPage(@RequestParam(defaultValue ="15")int limit, @RequestParam (defaultValue = "1") int page){
//        List<DutyQueue> dutyQueues=dutyQueueMapper.selectList(null);
        ResultMsg resultMsg=queueService.getQueueByPage(page,limit);
        return resultMsg;
    }


}
