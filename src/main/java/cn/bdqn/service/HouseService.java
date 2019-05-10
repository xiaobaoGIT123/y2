package cn.bdqn.service;

import cn.bdqn.coots.Pages;
import cn.bdqn.coots.Pages;
import cn.bdqn.pojo.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseService {

    //根据id查找房子
    House getHoseById(int id);

    //(查看所有的房子信息)
    List<House> getHouse();

    //(添加房子)
    int addHouse(House house);

    int getHouseCount(Map<String,Object> map);

    //分页查询房子
    List<House> getHouseByPage(Map<String,Object> map , Pages page);
}

