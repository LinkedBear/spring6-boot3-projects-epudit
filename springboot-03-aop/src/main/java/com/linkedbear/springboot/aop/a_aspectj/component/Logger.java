package com.linkedbear.springboot.aop.a_aspectj.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    
    @Before("execution(public void com.linkedbear.springboot.aop.a_aspectj.service.FinanceService.addMoney(double))")
//    @Before("@annotation(com.linkedbear.springboot.aop.a_aspectj.annotation.Log)")
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }
    
    @After("execution(public * com.linkedbear.springboot.aop.a_aspectj.service.FinanceService.*(*)))")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }
    
    @AfterReturning("execution(public * com.linkedbear.springboot.aop.a_aspectj.service.*.*(..)))")
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }
    
    @AfterThrowing("execution(* com.linkedbear.springboot.aop.a_aspectj.service.*.*(..) throws java.lang.Exception)")
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }
    
    @Around("execution(* com.linkedbear.springboot.aop.a_aspectj.service.FinanceService.addMoney(*))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }
}