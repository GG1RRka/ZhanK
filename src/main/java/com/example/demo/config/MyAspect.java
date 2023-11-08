package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("execution(* com.example.demo.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method hasn't yet been executed.");
    }

    @AfterReturning("execution(* com.example.demo.service..*(..))")
    public void logAfterReturn(JoinPoint joinPoint){
        log.info("Result is returned by method");
    }

    @AfterThrowing("execution(* com.example.demo.service..*(..))")
    public void logAfterThrow(JoinPoint joinPoint){
        log.info("An exception is thrown by method");
    }

    @After("execution(* com.example.demo.service..*(..))")
    public void logAfterFinally(JoinPoint joinPoint){
        log.info("Method was executed or exception is thrown.\n");
    }
}