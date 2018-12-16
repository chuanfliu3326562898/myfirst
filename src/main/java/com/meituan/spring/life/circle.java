package com.meituan.spring.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class circle implements InitializingBean,DisposableBean {
    public void destroy() throws Exception {
        System.out.println("destroy circle");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("init circle");
    }
}
