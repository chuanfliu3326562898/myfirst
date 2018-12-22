package com.jiangfengliu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhaozhiliang
 * @create 2018-05-15 下午5:56
 */
@Slf4j
@Component
public class SpringLogAspect {
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1 = System.currentTimeMillis();
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();


        Class<?> classTarget = pjp.getTarget().getClass();
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method objMethod = classTarget.getMethod(methodName, par);

        //SpringLogAround aCache=classTarget.getAnnotationsByType(SpringLogAround.class);
        SpringLogAround aCache = objMethod.getAnnotation(SpringLogAround.class);
        if (aCache != null) {
            System.out.println("-------SpringLogAspect----------");
            System.out.println("-----------------获取注解实现类上的注解:"+aCache.interfaceDesc());
            System.out.println("---------SpringLogAspect--------");
        }
        return  pjp.proceed();
    }
}
