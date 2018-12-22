package com.jiangfengliu.intercepter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用注释方式实现di
 * Created by sange on 2017/6/1.
 */
@Aspect
@Component
public class UserInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInterceptor.class);



    @Pointcut("target(com.jiangfengliu.service.UserService)")
    private void webMethod() {}

    @Before("webMethod()")
    public void validateUser(){
        System.out.println("UserInterceptor 用户合法");
    }
}
