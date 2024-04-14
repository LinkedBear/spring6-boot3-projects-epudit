package com.linkedbear.springboot.practice.config;

import com.linkedbear.springboot.practice.bean.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties(Person.class)
public class ConfigurationPropertiesConfiguration {
    
    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person person() {
        return new Person();
    }
}
