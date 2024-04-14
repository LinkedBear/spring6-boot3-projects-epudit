package com.linkedbear.springboot.webmvc.l_servietapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CrossOriginConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedMethods("GET", "POST").allowedOrigins("*").allowCredentials(true);
    }
}
