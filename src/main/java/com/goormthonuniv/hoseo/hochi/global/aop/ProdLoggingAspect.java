package com.goormthonuniv.hoseo.hochi.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Profile("prod")
public class ProdLoggingAspect {

    @Around("execution(* com.goormthonuniv.hoseo.hochi..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();

        log.info("[START] {}", methodName);

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("[END] {} ({}ms)", methodName, end - start);
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.error("[EXCEPTION] {} ({}ms)", methodName, end - start);
            throw e;
        }
    }
}
