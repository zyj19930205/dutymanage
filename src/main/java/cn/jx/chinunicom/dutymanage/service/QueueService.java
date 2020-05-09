package cn.jx.chinunicom.dutymanage.service;

import cn.jx.chinunicom.dutymanage.entity.DutyQueue;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;

import java.util.List;

public interface QueueService {
    ResultMsg getQueueByPage(int page, int limit);
}
