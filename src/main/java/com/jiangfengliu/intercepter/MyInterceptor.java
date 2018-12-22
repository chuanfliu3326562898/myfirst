package com.jiangfengliu.intercepter;

import com.jiangfengliu.aspect.SpringLogAround;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 使用配置文件方式进行di
 * 可参考:
 * https://blog.csdn.net/u012843873/article/details/80540499
 */
public class MyInterceptor implements MethodInterceptor {

  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("==before==");
    SpringLogAround springLogAround = invocation.getClass().getAnnotation(SpringLogAround.class);
    if (springLogAround != null) {
      System.out.println("MyInterceptor:" + springLogAround.interfaceDesc());
    }

    SpringLogAround requiredInterceptor = AnnotationUtils.findAnnotation(invocation.getMethod(), SpringLogAround.class);
    if(requiredInterceptor!=null){
      System.out.println(invocation.getMethod().getName()+"："+requiredInterceptor.interfaceDesc());
      //你要做的逻辑代码
    }

    Object result = invocation.proceed();
    System.out.println("==after==");
    return result;
  }
}