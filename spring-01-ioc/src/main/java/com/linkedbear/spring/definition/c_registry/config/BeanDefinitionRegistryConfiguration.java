package com.linkedbear.spring.definition.c_registry.config;

import com.linkedbear.spring.definition.c_registry.register.PersonRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersonRegister.class)
public class BeanDefinitionRegistryConfiguration {
    
}
