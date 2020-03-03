package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> selectUser();
    List<User> selectByUserNameAndPassword(String username,String password);
}
