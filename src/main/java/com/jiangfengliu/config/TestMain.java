package com.jiangfengliu.config;

import com.jiangfengliu.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 以容器方式启动工程http://www.cnblogs.com/duanxz/p/7493276.html
 */
public class TestMain {
    public static void main(String[] args) {

        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        //ApplicationContext context = new AnnotationConfigApplicationContext(Configer.class);

        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        //        ClassPathXmlApplicationContext("D:\\IdeaProjects\\myfirst\\src\\main\\resources\\conf\\spring-config.xml");

//         ApplicationContext context =
//           new FileSystemXmlApplicationContext("D:\\IdeaProjects\\myfirst\\src\\main\\resources\\conf\\spring-config.xml");


        ApplicationContext context2 = new ClassPathXmlApplicationContext(new String[]{"D:\\IdeaProjects\\myfirst\\src\\main\\resources\\conf\\spring-config.xml"});

        //获取bean
        User tb = (User) context2.getBean("user");
        System.out.println(tb.getName());
    }
}
