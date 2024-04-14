package com.linkedbear.spring.lifecycle.e_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleApplication {
    
    public static void main(String[] args) throws Exception {
        System.out.println("准备初始化IOC容器。。。");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.lifecycle.e_lifecycle.bean");
        System.out.println("IOC容器初始化完成。。。");
        ctx.start();
        System.out.println("IOC容器启动完毕。。。");
        
        System.out.println();
        
        System.out.println("准备关闭IOC容器。。。");
        ctx.stop();
        System.out.println("准备销毁IOC容器。。。");
        ctx.close();
        System.out.println("IOC容器销毁完成。。。");
    }
}
