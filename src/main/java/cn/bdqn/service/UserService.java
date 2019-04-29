package cn.bdqn.service;

import cn.bdqn.pojo.User;

public interface UserService {

    //根据用户id
    User getUserByUid(int id);

    //根据用户名和和角色查找用户
    User getUserByName(int role, String userName,String passWord);
}
