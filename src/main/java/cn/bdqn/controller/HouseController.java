package cn.bdqn.controller;

import cn.bdqn.pojo.House;
import cn.bdqn.pojo.TalkOrder;
import cn.bdqn.pojo.User;
import cn.bdqn.service.HouseService;
import cn.bdqn.service.TalkOrderService;
import cn.bdqn.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HouseController {


    private static Logger logger = Logger.getLogger(HouseController.class);

    @Resource
    HouseService houseService;
    @Resource
    TalkOrderService talkOrderService;
    @Resource
    UserService userService;

    @RequestMapping("/user.html")
   public String user(){
       return "userInfo";
   }

    @RequestMapping("/house.html")
    public String house(){
        return "houseInfo";
    }

    @RequestMapping("/regi.html")
    public String regi(){
        return "registered";
    }

    /**
     * 跳转到添加房源界面
     */
    @RequestMapping("/add.html")
    public String addHouse(){

        return "addHouse";
    }

}
