package com.linkedbear.springboot.aop.b_joinpoint.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class Logger {
    
    @Before("execution(* com.linkedbear.springboot.aop.b_joinpoint..*.addMoney(*))")
    public void beforePrint(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getTarget());
//        System.out.println(joinPoint.getThis());
        
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
        
//        System.out.println(joinPoint.getSignature());
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println(method.getName());
        
        System.out.println("Logger beforePrint run ......");
        System.out.println("被拦截的类：" + joinPoint.getTarget().getClass().getName());
        System.out.println("被拦截的方法：" + ((MethodSignature) joinPoint.getSignature()).getMethod().getName());
        System.out.println("被拦截的方法参数：" + Arrays.toString(joinPoint.getArgs()));
    }
    
    @After("execution(public * com.linkedbear.springboot.aop.b_joinpoint.service.FinanceService.*(*)))")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }
    
    @AfterReturning(value = "execution(public * com.linkedbear.springboot.aop.b_joinpoint.service.*.*(..)))", returning = "retval")
    public void afterReturningPrint(Object retval) {
        System.out.println("Logger afterReturningPrint run ......");
        System.out.println("返回的数据：" + retval);
    }
    
    @AfterThrowing(value = "execution(* com.linkedbear.springboot.aop.b_joinpoint.service.*.*(..) throws java.lang.Exception)", throwing = "e")
    public void afterThrowingPrint(Exception e) {
        System.out.println("Logger afterThrowingPrint run ......");
        System.out.println("抛出的异常：" + e.getMessage());
    }
    
    @Around("execution(* com.linkedbear.springboot.aop.b_joinpoint.service.FinanceService.addMoney(*))")
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