package com.linkedbear.springboot.jetcache.config;

import com.alicp.jetcache.support.Fastjson2ValueDecoder;
import com.alicp.jetcache.support.Fastjson2ValueEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JetcacheConfiguration {
    
    @Bean
    public Fastjson2ValueEncoder jsonEncoder() {
        return new Fastjson2ValueEncoder(false);
    }
    
    @Bean
    public Fastjson2ValueDecoder jsonDecoder() {
        return new Fastjson2ValueDecoder(false);
    }
}
