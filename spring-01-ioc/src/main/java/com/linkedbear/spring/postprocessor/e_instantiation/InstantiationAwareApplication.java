package com.linkedbear.spring.postprocessor.e_instantiation;

import com.linkedbear.spring.postprocessor.e_instantiation.bean.Ball;
import com.linkedbear.spring.postprocessor.e_instantiation.config.BallConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiationAwareApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BallConfiguration.class);
        Ball ball = (Ball) ctx.getBean("ball");
        System.out.println(ball);
        
        Ball ball2 = (Ball) ctx.getBean("ball2");
        System.out.println(ball2);
    }
}
