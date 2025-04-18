package com.linkedbear.spring.postprocessor.c_executetime.config;

import com.linkedbear.spring.postprocessor.c_executetime.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecuteTimeConfiguration {
    
    @Bean(initMethod = "initMethod")
    public Dog dog() {
        return new Dog();
    }
    
    @Bean
    public ExecuteTimeBeanPostProcessor executeTimeBeanPostProcessor() {
        return new ExecuteTimeBeanPostProcessor();
    }
}
