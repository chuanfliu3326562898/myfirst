package com.jiangfengliu.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author lhstack
 * @date 2021/8/22
 * @class CustomPropertySourcesPlaceholderConfigurer
 * @since 1.8
 */
public class PropertySourceLocatorProcessor implements EnvironmentAware, BeanFactoryPostProcessor {

    private AbstractEnvironment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (AbstractEnvironment) environment;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            Map<String, PropertySourceLocator> beansOfType = beanFactory.getBeansOfType(PropertySourceLocator.class);
            ApplicationPropertySourceLocator applicationPropertySourceLocator = new ApplicationPropertySourceLocator();
            applicationPropertySourceLocator.initEnvironment(this.environment, beanFactory);
            applicationPropertySourceLocator.locator().forEach(propertySource -> this.environment.getPropertySources().addLast(propertySource));
            beansOfType.values().forEach(item -> {
                item.initEnvironment(this.environment, beanFactory);
            });
            for (PropertySourceLocator value : beansOfType.values()) {
                value.locator().forEach(e -> {
                    this.environment.getPropertySources().addLast(e);
                });
            }
            //定义PropertySourcesPlaceholderConfigurer，用于解析标签里面spel表达式
            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = null;
            try {
                propertySourcesPlaceholderConfigurer = beanFactory.getBean(PropertySourcesPlaceholderConfigurer.class);
            } catch (Exception e) {
                propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            }
            propertySourcesPlaceholderConfigurer.setEnvironment(this.environment);
            propertySourcesPlaceholderConfigurer.setPropertySources(this.environment.getPropertySources());
            propertySourcesPlaceholderConfigurer.postProcessBeanFactory(beanFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
