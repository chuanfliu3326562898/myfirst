package com.jiangfengliu.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author lhstack
 * @date 2021/8/22
 * @class ApplicationPropertySourceLocator
 * @since 1.8
 */
public class ApplicationPropertySourceLocator implements PropertySourceLocator {

    @Override
    public void initEnvironment(Environment environment, ConfigurableListableBeanFactory beanFactory) {

    }

    @Override
    public List<PropertySource<?>> locator() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        List<PropertySource<?>> list = new ArrayList<>();
        propertiesPropertySource(list, contextClassLoader);
        yamlPropertySource(list, contextClassLoader);
        jsonPropertySource(list, contextClassLoader);
        return list;
    }

    /**
     * 加载application.json的配置内容
     * @param list
     * @param contextClassLoader
     * @throws IOException
     */
    private void jsonPropertySource(List<PropertySource<?>> list, ClassLoader contextClassLoader) throws IOException {
        InputStream in = contextClassLoader.getResourceAsStream("application.json");
        if (Objects.nonNull(in)) {
            Map<String, Object> map = PropertySourceUtils.parseJson(in);
            list.add(new MapPropertySource("application.json", map));
            in.close();
        }
    }

    /**
     * 加载application.yml|yaml等配置文件
     * @param list
     * @param contextClassLoader
     * @throws IOException
     */
    private void yamlPropertySource(List<PropertySource<?>> list, ClassLoader contextClassLoader) throws IOException {
        InputStream in = contextClassLoader.getResourceAsStream("conf/application.yml");
        if (Objects.nonNull(in)) {
            Map<String, Object> map = PropertySourceUtils.parseYaml(in);
            list.add(new MapPropertySource("conf/application.yml", map));
            in.close();
        }
        in = contextClassLoader.getResourceAsStream("conf/application.yaml");
        if (Objects.nonNull(in)) {
            Map<String, Object> map = PropertySourceUtils.parseYaml(in);
            list.add(new MapPropertySource("conf/application.yaml", map));
            in.close();
        }
    }

    /**
     * 加载properties配置文件
     * @param list
     * @param contextClassLoader
     * @throws IOException
     */
    private void propertiesPropertySource(List<PropertySource<?>> list, ClassLoader contextClassLoader) throws IOException {
        InputStream in = contextClassLoader.getResourceAsStream("conf/application1.properties");
        if (Objects.nonNull(in)) {
            Properties properties = new Properties();
            properties.load(in);
            properties.setProperty("meteor.servers", properties.getProperty("meteor.servers"));
            list.add(new PropertiesPropertySource("conf/application1.properties", properties));
            in.close();
        }
    }
}

