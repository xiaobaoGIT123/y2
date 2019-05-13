package cn.bdqn.service;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //根据用户id
    User getUserByUid(int id);

    //用户名同名验证
    User getUserByUsrName(@Param("userName") String userName) ;

    //用户注册
    int addUser(User user);

    //手机号码验证
    User getUserPhoneByPhone(String phone);
}
