package com.meituan.config;

import com.meituan.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *使用注释的配置方式
 */
@Configuration
public class Configer {
    @Bean(name="user",initMethod ="initMethod" )
    public User getUser(){
        return  new User();
    }
}
