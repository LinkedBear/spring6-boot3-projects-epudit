package com.linkedbear.springboot.starter.autoconfigure;

import com.linkedbear.springboot.starter.component.Cat;
import com.linkedbear.springboot.starter.component.Dog;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(prefix = "animal", name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({Cat.class, Dog.class})
public class AnimalAutoConfiguration {
    
//    @Bean
//    @ConfigurationProperties(prefix = "animal.dog")
    public Dog dog() {
        return new Dog();
    }
}
