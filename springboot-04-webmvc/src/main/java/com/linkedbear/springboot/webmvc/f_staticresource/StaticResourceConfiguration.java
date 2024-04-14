package com.linkedbear.springboot.webmvc.f_staticresource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@Configuration
public class StaticResourceConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/*");
        registry.addResourceHandler("/script/**").addResourceLocations("classpath:/static/js/*")
                .setCacheControl(CacheControl.maxAge(Duration.ofMinutes(30)));
    }
}
