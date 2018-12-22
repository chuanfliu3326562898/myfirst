package com.jiangfengliu.spring.life.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

  
/**
 * @desc 示例原来的网址：：：https://www.cnblogs.com/aspirant/p/9082858.html
 *
 * @author  作者 wangbiao 
 * @date 创建时间：2016年11月14日 上午11:11:35  
 * @parameter  
 * @return  
 */  
public class FactoryBeanTest {  
    public static void main(String[] args){  
        String url = "conf\\spring-config2.xml";
        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(url);
        Car car=  (Car)cpxa.getBean("car");
        //CarFactoryBean car= (CarFactoryBean) cpxa.getBean("&car");
        System.out.println(car.getBrand());
    }  
}