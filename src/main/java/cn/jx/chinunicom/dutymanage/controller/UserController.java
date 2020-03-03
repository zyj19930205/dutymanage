package cn.jx.chinunicom.dutymanage.controller;

import cn.jx.chinunicom.dutymanage.entity.User;
import cn.jx.chinunicom.dutymanage.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public String getUserInfo(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        List<User> users=userMapper.selectList(queryWrapper);
        if(users.size()==0){
            return "用户名或密码错误";
        }
        return "登陆成功！";
    }
}
