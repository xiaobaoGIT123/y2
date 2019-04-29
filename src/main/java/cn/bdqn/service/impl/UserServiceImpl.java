package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByUid(int id) {
        return userMapper.getUserByUid(id);
    }

    @Override
    public User getUserByName(int role, String userName, String passWord) {
        User user= userMapper.getUserByName(role, userName);

        if(user!=null){
            if(passWord.equals(user.getPassWord())){
                return user;
            }
        }

        return null;
    }

}
