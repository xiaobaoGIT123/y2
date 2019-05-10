package cn.bdqn.service.impl;

import cn.bdqn.coots.Pages;
import cn.bdqn.dao.HouseMapper;
import cn.bdqn.pojo.House;
import cn.bdqn.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Resource
    HouseMapper houseMapper ;


    @Override
    public House getHoseById(int id) {
        return houseMapper.getHoseById(id);
    }

    @Override//查看所有房子
    public List<House> getHouse() {

        return houseMapper.getHouse();
    }

    @Override
    public int addHouse(House house) {
        return houseMapper.addHouse(house);
    }

    @Override
    public int getHouseCount(Map<String, Object> map) {
        return houseMapper.getHouseCount(map);
    }

    @Override
    public List<House> getHouseByPage(Map<String, Object> map, Pages page) {
        return houseMapper.getHouseByPage(map,((page.getCurrentPage()-1)* page.getSize()),page.getSize());
    }
}
