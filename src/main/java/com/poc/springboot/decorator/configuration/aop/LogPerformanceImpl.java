package com.poc.springboot.decorator.configuration.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LogPerformanceImpl {


    // It will trigger for ServiceExampleA ServiceExampleB and ServiceExampleC
    @Pointcut("execution(public * execute(..))")
    public void checkServices() {
    }

    @Around("checkServices()")
    public Object checkServices(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("inside checkServices pointcut");
        return proceedingJoinPoint.proceed();
    }

    // Check ServiceExampleA to see how to use the annotation
    @Around("@annotation(LogPerformance)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final String methodName = proceedingJoinPoint.getSignature().getName();
        final StopWatch stopWatch = new StopWatch(methodName);
        stopWatch.start();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("{} took {} milliseconds to process", methodName, stopWatch.getTotalTimeMillis());
        }
    }
}
