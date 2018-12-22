package com.jiangfengliu.spring.life.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Service
public class BeanFactoryHelper implements BeanFactoryAware {
    
    private static BeanFactory beanFactory;


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryHelper.beanFactory = beanFactory;
    }

    public static Object getBean(String beanName){
        if(beanFactory == null){
            throw new NullPointerException("BeanFactory is null!");
        }
        return beanFactory.getBean(beanName);
    }
}