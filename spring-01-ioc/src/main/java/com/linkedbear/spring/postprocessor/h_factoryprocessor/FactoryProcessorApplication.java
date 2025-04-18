package com.linkedbear.spring.postprocessor.h_factoryprocessor;

import com.linkedbear.spring.postprocessor.h_factoryprocessor.bean.Green;
import com.linkedbear.spring.postprocessor.h_factoryprocessor.bean.Red;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryProcessorApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.h_factoryprocessor");
        Red red = ctx.getBean(Red.class);
        System.out.println(red);
        System.out.println(ctx.getBean(Green.class));
    }
}
