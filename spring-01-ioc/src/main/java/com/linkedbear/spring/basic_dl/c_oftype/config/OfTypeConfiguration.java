package com.linkedbear.spring.basic_dl.c_oftype.config;

import com.linkedbear.spring.basic_dl.c_oftype.dao.DemoDao;
import com.linkedbear.spring.basic_dl.c_oftype.dao.impl.DemoMySQLDao;
import com.linkedbear.spring.basic_dl.c_oftype.dao.impl.DemoOracleDao;
import com.linkedbear.spring.basic_dl.c_oftype.dao.impl.DemoPostgresDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfTypeConfiguration {
    
    @Bean
    public DemoDao demoMySQLDao() {
        return new DemoMySQLDao();
    }
    
    @Bean
    public DemoDao demoOracleDao() {
        return new DemoOracleDao();
    }
    
    @Bean
    public DemoDao demoPostgresDao() {
        return new DemoPostgresDao();
    }
}
