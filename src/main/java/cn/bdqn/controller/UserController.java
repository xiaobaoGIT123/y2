package cn.bdqn.controller;

<<<<<<< HEAD
import cn.bdqn.coots.Conts;
import cn.bdqn.pojo.House;
=======
>>>>>>> origin/master
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.ws.rs.HEAD;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);


    //    添加用户 跳转页面的方法
    @RequestMapping("/firstpage.html")
    public String addUser() {

        return "firstpage";
    }


    //    跳转页面
    @RequestMapping("/userlogin.html")
    public String userOrOwner(String opr, HttpServletRequest request) {
        logger.info(opr);
        if (opr.equals("user")) {
            logger.info("用户");
            request.setAttribute("user", "用户");
            request.setAttribute("roleId", 0);
        } else {
            logger.info("房主");
            request.setAttribute("user", "房主");
            request.setAttribute("roleId", 1);
        }
        return "userlogin";
    }


    //注册的方法
    @RequestMapping("/addSave.html")
    public String addSave(User user, HttpSession session, int role, MultipartFile Picture) {

        String idPicPath = "";
        if (!Picture.isEmpty()) {
            //获取文件的路径  File.separator系统的自适应分隔符
            String filePath = session.getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            //获取源文件名
            String fileOldName = Picture.getOriginalFilename();
            //获取文件的后缀
//            String sufix=fileOldName.substring(fileOldName.lastIndexOf(".")+1,fileOldName.length());
            String sufix = FilenameUtils.getExtension(fileOldName);
            List<String> sufixs = Arrays.asList(new String[]{"jpg", "png", "jpeg", "pneg"});
            if (Picture.getSize() > 500000) {
                session.setAttribute("uploadFileError", "文件太大了");
                return "userlogin";
            } else if (sufixs.contains(sufix)) {
                //重新命名，目的就是解决重名和字符乱码问题

                String fileName = System.currentTimeMillis() + new Random().nextInt(1000000) + "_person." + sufix;
                File file = new File(filePath, fileName);

//                File file2 = new File(fileName);//图片2
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    Picture.transferTo(file);
//                    Picture.transferTo(file2);

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
                } catch (Exception e) {
                    e.printStackTrace();
                    session.setAttribute("uploadFileError", "上传失败");
                    return "userlogin";
                }
                idPicPath = filePath + File.separator + fileName;
                System.out.println("=====>" + idPicPath);
            } else {
                session.setAttribute("uploadFileError", "文件格式不对");
                return "userlogin";
            }
        }

        user.setRole(role);
        logger.info(user.toString());
        user.setHeadPicture(idPicPath);

        int count = userService.addUser(user);

        if (count == 1) {
            logger.info("注册成功");
//           注册成功，跳转主页面
            return "main";
        } else {
            logger.info("注册失败");
            return " userlogin";
        }


    }

    //同名验证
    @RequestMapping("/ucexist.html")
    @ResponseBody
    public Object checkName(String userName) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        logger.info(userName);
        User user = userService.getUserByUsrName(userName);
        if (null != user) {
            logger.info("用户名已存在");
            resultMap.put("error", "用户名已存在");
        } else {
            logger.info("可用");
            resultMap.put("ok", "ok");
        }

        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getCode.html",method = RequestMethod.GET)
    @ResponseBody
    public String getCode(String phone, HttpSession session) {

        String codeid = "";
        String ret = "";
logger.info(phone);
        if (session.getAttribute("code") == null) {
            // 随机码
            int code = 0;
            while (code < 100000) {
                code = (int) (Math.random() * 999999);
            }
            //保存随机码
            session.setAttribute("code", code);
            session.setMaxInactiveInterval(60);
            logger.info(code);
            String PostData = null;
            try {
                PostData = "account=chenxiaobao&password=chen1995&mobile=" + phone + "&content=" + java.net.URLEncoder.encode("您的验证码是：【" + code + "】。请不要把验证码泄露给其他人。如非本人操作，可不用理会！", "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //out.println(PostData);
            ret = SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
            logger.info(ret);
            codeid = code + "";

        }
        logger.info(codeid);
        return JSONArray.toJSONString(codeid);
    }

    private String SMS(String postData, String postUrl) {

        try {

            // 发送POST请求

            URL url = new URL(postUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.setRequestProperty("Connection", "Keep-Alive");

            conn.setUseCaches(false);

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());

            OutputStreamWriter out = new OutputStreamWriter(
                    conn.getOutputStream(), "UTF-8");

            out.write(postData);

            out.flush();

            out.close();

            // 获取响应状态

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

                System.out.println("connect failed!");

                return "";
            }
            // 获取响应内容体

            String line, result = "";

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));

            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }

            in.close();

            return result;
        } catch (IOException e) {

            e.printStackTrace(System.out);
        }
         return "";
    }
}
