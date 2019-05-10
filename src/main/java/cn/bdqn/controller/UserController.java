package cn.bdqn.controller;

import cn.bdqn.coots.Conts;
import cn.bdqn.pojo.House;
import cn.bdqn.pojo.User;
import cn.bdqn.service.HouseService;
import cn.bdqn.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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

        session.removeAttribute("number");
       List<House> houseList=houseService.getHouse();

        for (House item:houseList) {
            item.setHousePicture(item.getHousePicture().split("/")[0]);
            item.setHouseTime(item.getHouseTime().split(" ")[0]);
            item.setHousePrice(item.getHousePrice()+"元/月");
        }

        session.setAttribute("houseList", houseList);

        //这下面的集合是用于滚播循环使用的
        List<House> playerList=houseList;
        session.setAttribute("playerList", playerList);
        return "main";
    }

    //进入登录界面
    @RequestMapping("/userLogin.html")
    public String userLogin(){

        return "userLogin";
    }


    /**
     * 登录验证
     * @param userName
     * @param passWord
     * @param role
     * @param session
     * @return
     */
    @RequestMapping(value = "/doLogin.html",method = RequestMethod.POST)
//    @ResponseBody
    public String doLogin(String userName, String passWord,
                          int role, HttpSession session,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {



        request.removeAttribute("error");
        User user=  userService.getUserByName(role , userName, passWord);
        if (user == null) {
            request.setAttribute("error", "用户名或密码不符...");
            return "redirect:/userLogin.html";
        } else {
            session.setAttribute(Conts.USER_SESSION, user);
        }
            return "main";
    }




    //退出
    @RequestMapping("/loginOut.html")
//    @ResponseBody
    public Object loginOut(HttpSession session){
//        boolean isgod=false;
        session.removeAttribute(Conts.USER_SESSION);
        if(session.getAttribute(Conts.USER_SESSION)==null){
            return "redirect:/login.html";
        }
            return "redirect:/doLogin.html";
    }
}
