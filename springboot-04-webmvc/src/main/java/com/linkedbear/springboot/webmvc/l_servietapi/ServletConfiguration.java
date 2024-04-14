package com.linkedbear.springboot.webmvc.l_servietapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {
    
    @Bean
    public DemoServlet2RegistrationBean demoServlet2RegistrationBean() {
        return new DemoServlet2RegistrationBean(new DemoServlet2(), "/servlet/demo2");
    }
}
