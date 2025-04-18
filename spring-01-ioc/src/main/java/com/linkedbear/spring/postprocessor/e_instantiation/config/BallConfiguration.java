package com.linkedbear.spring.postprocessor.e_instantiation.config;

import com.linkedbear.spring.postprocessor.e_instantiation.bean.Ball;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BallConfiguration {
    
    @Bean
    public Ball ball() {
        Ball ball = new Ball();
        ball.setId("注解球");
        return ball;
    }
    
    @Bean
    public BallFactoryInstantiationProcessor ballFactoryInstantiationProcessor() {
        return new BallFactoryInstantiationProcessor();
    }
    
    @Bean
    public Ball ball2() {
        return new Ball();
    }
}
