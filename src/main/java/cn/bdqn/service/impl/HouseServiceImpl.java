package cn.bdqn.service.impl;

import cn.bdqn.dao.HouseMapper;
import cn.bdqn.pojo.House;
import cn.bdqn.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
}
