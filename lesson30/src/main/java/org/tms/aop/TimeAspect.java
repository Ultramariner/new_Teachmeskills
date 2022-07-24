package org.tms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {

    @Pointcut("execution(* org.tms.service.RaceService.run(..))")  //если меняю run на getLapTime, то advice не отрабатывает
    public void timeServices() {
    }

    @Around("timeServices()")
    public int calcTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end - start);
        System.out.println(joinPoint.getSignature().getName());
        return 0;
    }
}
