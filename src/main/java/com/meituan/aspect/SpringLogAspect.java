package com.meituan.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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

    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object bizRet = null;
        Object[] params = jp.getArgs();

        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        String interfaceName = Joiner.on(".").join(methodSignature.getDeclaringType().getName(), methodSignature.getName());

        Method realMethod = jp.getTarget().getClass().getDeclaredMethod(signature.getName(), methodSignature.getMethod().getParameterTypes());

        LogDescriptionAround logDescriptionAround;
        //双重获取，保证jdk或cglib动态代理的目标都可得到注解对象
        logDescriptionAround = methodSignature.getMethod().getAnnotation(LogDescriptionAround.class);
        if (logDescriptionAround == null) {
            logDescriptionAround = realMethod.getAnnotation(LogDescriptionAround.class);
        }

        if (logDescriptionAround != null) {
            log.info("{}执行开始...", logDescriptionAround.interfaceDesc());
        }

        log.info("interface={}, type=spring_start, 入参:{}",
                interfaceName, JSON.toJSONString(params));

        bizRet = jp.proceed();

        log.info("interface={}, type=spring_end, cost={}, 返回结果:{}",
                interfaceName, (System.currentTimeMillis() - start), JSON.toJSONString(params));

        if (logDescriptionAround != null) {
            log.info("{}执行结束...", logDescriptionAround.interfaceDesc());
        }
        return bizRet;
    }
}
