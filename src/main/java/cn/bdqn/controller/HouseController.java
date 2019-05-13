package cn.bdqn.controller;

import cn.bdqn.coots.Conts;
import cn.bdqn.coots.Pages;
import cn.bdqn.pojo.House;
import cn.bdqn.pojo.TalkOrder;
import cn.bdqn.pojo.User;
import cn.bdqn.service.HouseService;
import cn.bdqn.service.TalkOrderService;
import cn.bdqn.service.UserService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public String showHouse(){

        return "addHouse";
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "/getList.html",method = RequestMethod.POST)
//    @ResponseBody
    public Object getListByPage(@RequestParam int houseTypeId,
                                @RequestParam String housePrice,
                                @RequestParam String houseAddress,
                                HttpSession session,
                                HttpServletResponse response){
        session.removeAttribute("number");
        int housePrice1=Integer.parseInt(housePrice.split("/")[0]);
        int housePrice2=Integer.parseInt(housePrice.split("/")[1]);

        System.out.print("房源类型id>>"+houseTypeId);
        System.out.print("房源价格开始>>"+housePrice1);
        System.out.print("房源价格结束>>"+housePrice2);
        System.out.print("房源地址>>"+houseAddress);

        String opr="";//定义标识
         if(houseTypeId ==0 && housePrice1 == 0 && ("".equals(houseAddress) || houseAddress.equals(null))){
            opr="all";
        }else if(houseTypeId==0 && housePrice1==0 && !("".equals(houseAddress) || houseAddress.equals(null))){
             opr="dizhi";
         }else if(houseTypeId==0 && housePrice1==0 ){
            opr="quanbu";
        }else if(houseTypeId==0 && housePrice1 != 0){
            opr="jiage";
        }else if(houseTypeId !=0 && housePrice1 == 0){
            opr="leixing";
        }
        System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+opr+"<<<");

        Map<String,Object> map= new HashMap<String,Object>();
        map.put("opr",opr);
        map.put("houseTypeId", houseTypeId);
        map.put("housePrice1", housePrice1);
        map.put("housePrice2", housePrice2);
        map.put("houseAddress", houseAddress);
        System.out.print("这是》》》》》》》》》"+map.get("opr"));

        if("all".equals(opr)){//查询全部
            logger.info("进了这里--------------------------<");
            return "redirect:/login.html";
        }

        Pages page = new Pages();
        int coun = houseService.getHouseCount(map);
        logger.info("返回条数--------------------------<"+coun);

        page.setSize(100);
        page.setTotalCount(coun);
        page.setCurrentPage(1);

        map.put("page", page);



            List<House> houseList= houseService.getHouseByPage(map,page);
            logger.info("返回list条数--------------------------<"+houseList.size());

            for (House item:houseList) {
                item.setHousePicture(item.getHousePicture().split("/")[0]);
                item.setHouseTime(item.getHouseTime().split(" ")[0]);
                item.setHousePrice(item.getHousePrice()+"元/月");
            }
            String number="为您找到"+houseList.size()+"条相关信息";
            session.setAttribute("number", number);
            session.setAttribute("houseList", houseList);
            return "main";


    }





    /**
     * 添加房源信息
     */
    @RequestMapping(value = "/addHome.html",method = RequestMethod.POST)
    public String addHome(HttpSession session, House house,
                          @RequestParam(value = "file_input",required = false)
                                      MultipartFile file_input[]){

        User users=(User)session.getAttribute((Conts.USER_SESSION));
        int id=users.getUid();//房子拥有者
        String lastPicturePath="";//图片路径
        session.removeAttribute("uploadError");

        //图片上传

        //判断文件是否为空
        if(file_input!=null){
            //循环多个图片文件
            for (int i=0;i<file_input.length;i++){
                if(!file_input[i].isEmpty()){
                    //获取文件的存储路径，File.separator是系统的自适应分隔符
                    String filePath=session.getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
                    String bendiPath="D:\\idea编程开发工具\\fhouse\\src\\main\\webapp\\statics\\uploadfiles";
                    //获取源文件名
                    String oldFileName=file_input[i].getOriginalFilename();
                    //获取文件名的后缀
                    String sufixName=oldFileName.substring(oldFileName.lastIndexOf(".")+1,oldFileName.length());
                    //创建合法的文件格式后缀集合
                    List<String> fileSufix= Arrays.asList(new String[]{"jpg","png","jpeg","pneg"});
                    //判断文件大小
                    if(file_input[i].getSize()>5000000){
                        session.setAttribute("uploadError", "文件太大，无法上传哦！");
                        return "addHouse";
                        //判断文件格式是否正确
                    }else if(fileSufix.contains(sufixName)){
                        //给文件重新命名
                        //当前时间的毫秒数+一百万的随机数+格式后缀
                        String fileName=System.currentTimeMillis()+new Random().nextInt(1000000)+"_person."+sufixName;
                        //创建文件，开始上传
                        File file =new File(filePath,fileName);
                        File file2=new File(bendiPath,fileName);
                        if(!file.exists()){//判断文件路径是否存在
                            file.mkdirs();
                        }

                        try {
                            file_input[i].transferTo(file);
                            file_input[i].transferTo(file2);
                        } catch (IOException e) {
                            e.printStackTrace();
                            session.setAttribute("uploadError", "上传失败！");
                            return "addHouse";
                        }
                        lastPicturePath+=fileName+"/";
                    }else{
                            session.setAttribute("uploadError", "文件格式不对!!!");
                            return "addHouse";
                    }
                }
            }//循环结束

        }

        //获取普通信息
        house.setHouseStatus(0);//房子状态
        house.setHouseUser(id);//房子拥有者4
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String times=date.format(new Date());
        house.setHouseTime(times);//发布时间
        house.setHousePicture(lastPicturePath);//图片路径

        int answer= houseService.addHouse(house);
        if(answer==1){
            return "redirect:/login.html";
        }else {
            session.setAttribute("uploadError", "上传失败！");
            return "addHouse";
        }
    }
}
