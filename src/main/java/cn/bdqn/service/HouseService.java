package cn.bdqn.service;

import cn.bdqn.pojo.House;

import java.util.List;

public interface HouseService {

    //根据id查找房子
    House getHoseById(int id);

    //(查看所有的房子信息)
    List<House> getHouse();
}

