package cn.bdqn.controller;
import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.apache.log4j.Logger;
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
import java.util.Random;

@Controller
public class UserController {

    @Resource
    HouseService houseService;
    @Resource
    UserService userService;
    private static Logger logger = Logger.getLogger(HouseController.class);

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

    //进入找回密码的界面
    @RequestMapping("/findPwd.html")
    public String findPwd(){

        return "findPwd";
    }

    //进入其他登录方式的界面
    @RequestMapping("/qitalogin.html")
    public String qitalogin(){

        return "qiatlogin";
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
    public String doLogin(String userName, String passWord,
                          int role, HttpSession session,
                          HttpServletRequest request,
                          HttpServletResponse response){


        User user= userService.getUserByNameAndRole(role , userName, passWord);
        if (user == null) {
            session.setAttribute("error", "用户名或密码不符...");
            return "userLogin";
        } else {
            session.setAttribute(Conts.USER_SESSION, user);
        }
            return "main";
    }

    //退出的方法
    @RequestMapping("/loginOut.html")
    public Object loginOut(HttpSession session){
        session.removeAttribute(Conts.USER_SESSION);
        if(session.getAttribute(Conts.USER_SESSION)==null){
            return "redirect:/login.html";
        }
        return "redirect:/doLogin.html";
    }


    //找回密码之查询是否存在此用户
    @RequestMapping(value = "/changUser.html",method = RequestMethod.POST)
    @ResponseBody
    public Object changUser(String userName,String phone){
        User users=userService.getUserByUsrName(userName);

        int answer=0;
        if(users!=null){
            answer=1;
            if(users.getPhone().equals(phone)){
                answer=2;
            }
        }
        return JSON.toJSONString(answer);

    }
    //发送验证码
    @RequestMapping(value = "/faSong.html",method = RequestMethod.POST)
    @ResponseBody
    public Object faSong(String phone){


        //生成6位验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);

//        try {
//
//        //发送验证码
//        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "101511", "ffc818a3-7913-45de-a6d7-18e8ab4d61cb");
//
//            JSONObject json = null;
//
//            System.out.print("进了控制层>>>"+verifyCode+"电话号码："+phone);
//
//            //书写内容
//            String result = client.send(phone, "代码测试那边给你发了一条验证码：" +
//                    ""+verifyCode+"若非本人操作请不要理会");
//
//            json = JSONObject.parseObject(result);
//            if(json.getIntValue("code") != 0){//发送短信失败
//                return JSON.toJSONString("119");
//            }
//            System.out.print("发送结果>>>"+result);
//            int answer=json.getIntValue("code");
//            return JSON.toJSONString(verifyCode);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.print("随机数》》》》》"+verifyCode);
            return verifyCode;
    }


    //根据手机号码修改密码的方法
    @RequestMapping("/uopdateByNumber.html")
    @ResponseBody
    public String uopdateByNumber(String phone,String passWord){
        System.out.print("传过来的电话号码>>>>>"+phone);
        System.out.print("新密码>>>>>"+passWord);

        int answer=userService.udateUserPwdByPhone(phone,passWord);
        System.out.print("结果>>>>>"+userService.udateUserPwdByPhone(phone,passWord));
        return JSON.toJSONString(answer);

    }

    //查询用户未读信息的方法



}
