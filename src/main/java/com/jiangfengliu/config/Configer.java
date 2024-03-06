package com.jiangfengliu.config;

import com.alibaba.fastjson.JSONArray;
import com.jiangfengliu.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/*
 *使用注释的配置方式
 */
@Configuration
@PropertySource("classpath:conf/application.properties")
public class Configer {
//    @Value("${meteor.servers}")
//    private List<Server> servers;
//    @Value("${meteor.servers}")
//    private Server[] servers;
    @Autowired
    private MeteorClientProperty clientProperty;
    @Bean(name = "user", initMethod = "initMethod")
    public User getUser() {
        return new User();
    }

//    @Value("${meteor.client.port:0}")
//    private Integer clientPort;
//    @Value("${driver}")
//    private String driver;
    @PostConstruct
    public void init(){
        System.out.println(clientProperty);
    }

    @Data
    public static class Server{
        private String host;
        private String port;
    }
}

