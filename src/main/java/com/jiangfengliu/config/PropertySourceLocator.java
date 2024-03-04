package com.jiangfengliu.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.util.List;

/**
 * @author lhstack
 * @date 2021/8/22
 * @class PropertySourceLocator
 * @since 1.8
 */
public interface PropertySourceLocator {

    /**
     * 加载propertySource
     *
     * @return
     */
    List<PropertySource<?>> locator() throws IOException;


    /**
     * 初始化环境变量
     *
     * @param environment
     * @param beanFactory
     */
    default void initEnvironment(Environment environment, ConfigurableListableBeanFactory beanFactory) {

    }

}

