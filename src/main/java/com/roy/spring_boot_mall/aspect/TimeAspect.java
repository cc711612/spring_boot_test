package com.roy.spring_boot_mall.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.roy.spring_boot_mall.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();
        // 切入點
        Object obj = pjp.proceed();
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("運行時間" + time + " ms");
        return obj;
    }
}
