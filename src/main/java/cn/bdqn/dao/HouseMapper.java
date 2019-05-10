package cn.bdqn.dao;

import cn.bdqn.coots.Pages;
import cn.bdqn.pojo.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    //(查看所有的房子信息)
    List<House> getHouse();

    //分页查询房子
    List<House> getHouseByPage(@Param("map") Map<String,Object> map , @Param("currentPage")Integer currentPage,@Param("size")Integer size);

    //查询总记录数
    int getHouseCount(Map<String,Object> map);
}
