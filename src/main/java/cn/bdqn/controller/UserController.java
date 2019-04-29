package cn.bdqn.controller;

import cn.bdqn.pojo.House;
import cn.bdqn.pojo.User;
import cn.bdqn.service.HouseService;
import cn.bdqn.service.UserService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Resource
    HouseService houseService;
    @Resource
    UserService userService;


    /**
     * 进入主界面
     * @return
     */
    @RequestMapping("/login.html")
    public String login(HttpSession session){

       List<House> houseList=houseService.getHouse();

        session.setAttribute("houseList", houseList);

        return "main";
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     * @param role
     * @param session
     * @return
     */
    @RequestMapping(value = "/doLogin.html",method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(String userName, String passWord, int role, HttpSession session){
        System.out.print("进了后台....");
        User user=  userService.getUserByName(role , userName, passWord);
        if(user!=null){
            return JSONArray.toJSONString(user);
        }
        return JSONArray.toJSONString(null);

    }
}
