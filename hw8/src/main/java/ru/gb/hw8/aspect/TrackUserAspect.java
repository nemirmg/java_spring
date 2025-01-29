package ru.gb.hw8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TrackUserAspect {

    private Logger logger = Logger.getLogger(TrackUserAspect.class.getName());

    @Around("execution(* ru.gb.hw8.controller.*.*(..))")
    public Object loggingControllerMethodsWithArgs(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info(String.format("Execute controller method. Call method: %s", methodName));
        return joinPoint.proceed();
    }

    @Around("@annotation(ru.gb.hw8.aspect.TrackUserAction)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @AfterReturning(value = "@annotation(ru.gb.hw8.aspect.TrackUserAction)", returning = "returnedValue")
    public void loggingWhenCallTrackUserAction(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);
    }
}