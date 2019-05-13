package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    //根据用户和角色查找用户
    User getUserByNameAndRole(@Param("role") int role, @Param("userName") String userName);

    //(用户名验证)
    User getUserByUsrName(String userName) ;

    //(根据id查找User信息)
    User getUserByUid(int uid);

    //(修改个人信息)
    int updateUserById(User user);

    //(添加用户)
    int addUser(User user);

    //(修改举报次数+1,子查询)
    int updateReportCountById(int id);

    //根据手机号码修改用户密码
    int udateUserPwdByPhone(@Param("phone") String phone,@Param("passWord") String passWord);
}
