package cn.jx.chinunicom.dutymanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value={"","/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/EmployeeManage")
    public String toManage(){
        return "manage/employeeManage";
    }

    @RequestMapping("/DutyHistory")
    public String toDutyHistory(){
        return "manage/DutyHistory";
    }

    @RequestMapping("/DutyManage")
    public String toDutyManage(){
        return "manage/dutyManage";
    }

    @RequestMapping("/AutoDuty")
    public String AutoDuty(){
        return "manage/autoDuty";
    }
    @RequestMapping("/dutyCalendar")
    public String dutyCalendar(){
        return "manage/dutyCalendar";
    }


    @RequestMapping("/testManage")
    public String testManage(){
        return "manage/testManage";
    }

    @RequestMapping("/testNav")
    public String testNav(){
        return "common/leftNav";
    }
}
