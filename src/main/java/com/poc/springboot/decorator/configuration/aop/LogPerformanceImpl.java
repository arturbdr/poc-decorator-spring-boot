package com.poc.springboot.decorator.configuration.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LogPerformanceImpl {

    // Check ServiceExampleA to see how to use the annotation
    @Around("@annotation(LogPerformance)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("{} took {} milliseconds to process", proceedingJoinPoint.getSignature(), stopWatch.getTotalTimeMillis());
        }
    }
}
