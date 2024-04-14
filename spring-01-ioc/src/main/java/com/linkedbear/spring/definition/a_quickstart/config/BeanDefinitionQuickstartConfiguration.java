package com.linkedbear.spring.definition.a_quickstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linkedbear.spring.definition.a_quickstart.bean.Person;

@Configuration
public class BeanDefinitionQuickstartConfiguration {
    
    @Bean
    public Person person() {
        return new Person();
    }
}
