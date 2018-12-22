package com.jiangfengliu.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Created by zhaozhiliang on 2018/3/28
 */
@Slf4j
@Component
public class LogAspect {

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1 = System.currentTimeMillis();
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();


        Class<?> classTarget = pjp.getTarget().getClass();
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method objMethod = classTarget.getMethod(methodName, par);

        LogDescriptionAround aCache = objMethod.getAnnotation(LogDescriptionAround.class);
        if (aCache != null) {
            System.out.println("-----------------");
            System.out.println("-----------------获取注解实现类上的注解:"+aCache.interfaceDesc());
            System.out.println("-----------------");
        }
        return  pjp.proceed();
    }

    public Object doAround2(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("LogAspect start");
        long start = System.currentTimeMillis();
        Object bizRet;
        Object[] params = jp.getArgs();

        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String targetType = methodSignature.getDeclaringType().getName();
        String interfaceName = Joiner.on(".").join(targetType, methodSignature.getName());

        //Method realMethod = jp.getTarget().getClass().getDeclaredMethod(signature.getName(), methodSignature.getMethod().getParameterTypes());
        Method realMethod = getDeclaredMethod(jp.getTarget().getClass(),signature.getName(), methodSignature.getMethod().getParameterTypes());
        LogDescriptionAround logDescriptionAround;
        //双重获取，保证jdk或cglib动态代理的目标都可得到注解对象
        logDescriptionAround = methodSignature.getMethod().getAnnotation(LogDescriptionAround.class);
        if (logDescriptionAround == null) {
            logDescriptionAround = realMethod.getAnnotation(LogDescriptionAround.class);
        }

        if (logDescriptionAround != null) {
            log.info("{}执行开始...", logDescriptionAround.interfaceDesc());
        }

        String type = "";
        String description = "";
        Point point = new Point(description, type, interfaceName, start);

//        logParams(point, params);
        bizRet = jp.proceed();
//        logResult(point, bizRet);

        if (logDescriptionAround != null) {
            log.info("{}执行结束...", logDescriptionAround.interfaceDesc());
        }

        return bizRet;
    }

    public  Method getDeclaredMethod(Class clazz, String methodName, Class<?> ... parameterTypes){
        Method method = null ;
        for( ; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes) ;
                return method ;
            } catch (Exception e) {
                //这里什么都不做，找不到方法则继续去父类找
            }
        }
        return null;
    }

    private void logParams(Point point, Object[] params) {
        if (StringUtils.isBlank(point.getType())) {
            return;
        }
        log.info("{}, interface={}, type={}_start, 入参:{}",
                point.getDescription(), point.getInterfaceName(), point.getType(), JSON.toJSONString(params));
    }

    private void logResult(Point point, Object bizRet) {
        if (StringUtils.isBlank(point.getType())) {
            return;
        }

        log.info("{}, interface={}, type={}_end, cost={}, 返回结果:{}",
                point.getDescription(), point.getInterfaceName(), point.getType(),
                (System.currentTimeMillis() - point.getStartTime()), JSON.toJSONString(bizRet));
    }

    private void logErrors(Point point, Throwable throwable) {
        log.error("{}, interface={}, type={}_error, cost={}",
                point.getDescription(), point.getInterfaceName(), point.getType(), (System.currentTimeMillis() - point.getStartTime()), throwable);
    }

    @Data
    @AllArgsConstructor
    class Point {
        String description;
        String type;
        String interfaceName;
        long startTime;
    }
}
