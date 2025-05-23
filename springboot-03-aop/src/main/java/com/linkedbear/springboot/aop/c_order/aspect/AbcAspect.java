package com.linkedbear.springboot.aop.c_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AbcAspect {
    
    @Before("execution(* com.linkedbear.springboot.aop.c_order.service.UserService.*(..))")
    public void abc() {
        System.out.println("abc abc abc");
    }
    
    @Before("execution(* com.linkedbear.springboot.aop.c_order.service.UserService.*(..))")
    @Order(Ordered.HIGHEST_PRECEDENCE) // 不生效
    public void def() {
        System.out.println("def def def");
    }
    
    @Before("execution(* com.linkedbear.springboot.aop.c_order.service.UserService.*(..))")
    public void bcd() {
        System.out.println("bcd bcd bcd");
    }
}
