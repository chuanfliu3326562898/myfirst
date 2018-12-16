package com.meituan.intercepter;

import com.meituan.aspect.SpringLogAround;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
* 使用配置文件方式进行di
* */
public class MyInterceptor implements MethodInterceptor{

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("==before==");
        System.out.println(invocation.getMethod().getAnnotation(SpringLogAround.class).interfaceDesc());
        Object result= invocation.proceed();
        System.out.println("==after==");
        return result;
    }
}