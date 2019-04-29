package cn.bdqn.test;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_1 {
    private static Logger logger = Logger.getLogger(Test_1.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
    public void dts(){

    }
}
