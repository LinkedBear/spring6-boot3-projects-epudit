package com.linkedbear.springboot.webmvc.j_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    
    @Autowired
    private DemoInterceptor1 demoInterceptor1;
    @Autowired
    private DemoInterceptor2 demoInterceptor2;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(demoInterceptor).addPathPatterns("/department/**");
        registry.addInterceptor(demoInterceptor1).addPathPatterns("/department/**");
        registry.addInterceptor(demoInterceptor2).addPathPatterns("/department/**");
    }
}
