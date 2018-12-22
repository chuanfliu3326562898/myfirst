package com.jiangfengliu.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhaozhiliang on 2018/4/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDescriptionAround {
    /**
     * 接口名称
     */
    String interfaceName() default "";

    /**
     * 接口说明
     */
    String interfaceDesc() default "";
}
