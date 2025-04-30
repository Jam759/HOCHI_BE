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
@Profile({"local", "dev"})
public class DevLoggingAspect {

    //com.goormthonuniv.hoseo.hochi

    @Around("execution(* com.goormthonuniv.hoseo.hochi..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("🛫 [START] 메서드: {}", methodName);
        for (Object arg : args) {
            log.info("   ➡️ 파라미터: {}", arg);
        }

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("✅ [END] 메서드: {} (소요시간: {}ms)", methodName, end - start);
            log.info("   ⬅️ 반환값: {}", result);
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.error("❌ [EXCEPTION] 메서드: {} (소요시간: {}ms)", methodName, end - start);
            log.error("   ⛔ 예외: {}", e.getMessage());
            throw e;
        }
    }
}
