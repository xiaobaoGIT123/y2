package cn.bdqn.dao;

import cn.bdqn.pojo.User;


public interface UserMapper {


    //(登陆)
    User getUserByUsrNameAndRole(String userName, Integer role) ;



    //(根据id查找User信息)
    User getUserByUid(int uid);

    //(修改个人信息)
    int updateUserById(User user);



    //(修改举报次数+1,子查询)
    int updateReportCountById(int id);


    //(用户名验证)
    User getUserByUsrName(String userName) ;

    //(添加用户)
    int addUser(User user);
}
