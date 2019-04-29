package cn.bdqn.dao;

import cn.bdqn.pojo.House;

import java.util.List;

/**
 *
 */
public interface HouseMapper {


    //(查看所有房源) 价格,类型,地址,分页,根据时间倒序
//    List<House> getHouseList(Page page, House house);

    //(根据id查找房子)
    House getHoseById(int hid);

    //(添加房子)
    int addHouse(House house);

    //(修改房子)
    int updateHouseById(House house);

    //((删除房子)
    int deleteHouseById(int hid);

    //(根据房主id查找房子信息集合)
    List<House> getHouseByHouseUser(int userId);

    //(根据时间查找房子信息集合)
    List<House> getHouseByHouseTime(String time);
}
