package com.linkedbear.spring.lifecycle.a_initmethod.config;

import com.linkedbear.spring.lifecycle.a_initmethod.bean.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitMethodConfiguration {
    
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DataSource annotationDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setName("annotationDataSource");
        return dataSource;
    }
    
}
