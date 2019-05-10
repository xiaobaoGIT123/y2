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
    public User getUserByUsrName(String userName) {
        return userMapper.getUserByUsrName(userName);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
