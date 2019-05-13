package cn.bdqn.service;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //根据用户id
    User getUserByUid(int id);

    //(用户名验证)
    User getUserByUsrName(String userName) ;

    //根据用户名和和角色查找用户
    User getUserByNameAndRole(int role, String userName,String passWord);

    //根据手机号码修改用户密码
    int udateUserPwdByPhone(String phone,String passWord);
}
