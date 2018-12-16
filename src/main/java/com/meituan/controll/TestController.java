package com.meituan.controll;

import com.meituan.response.ResponseVo;
import com.meituan.spring.life.aware.BeanFactoryHelper;
import com.meituan.spring.life.factorybean.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.meituan.model.User;
import com.meituan.service.UserService;

/**
 * Created by liujiangfeng on 2017/7/7.
 */
@Controller
@RequestMapping(value="/base")
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询单个用户
     * @param id
     * @desc 此处代码是返回的一个查询的bean文件
     * @return
     */
    @RequestMapping("/test/{id}")
    @ResponseBody
    public User test(@PathVariable int id) {
        System.out.println(id);
        User userName= userService.findNameById(id);
        return userName;
    }

    /**
     * @param id
     * @desc 此处代码是返回的一个查询的bean文件
     * @return
     */
    @RequestMapping(value="/test2")
    @ResponseBody
    public ResponseVo test2(int id, int id2) {
        System.out.println(id);
        //User userName= userService.findNameById(id);
        ResponseVo<String,String> response=new ResponseVo("test","ok");

        return response;
    }


    @RequestMapping("/getAware")
    @ResponseBody
    public String getUser(){
        //此name为beanId
        Car result=(Car)BeanFactoryHelper.getBean("carAware");
        return result.getBrand();
    }
}
