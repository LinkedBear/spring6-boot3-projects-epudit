package com.linkedbear.springboot.webmvc.e_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class JsonConfiguration {
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
        objectMapper.setTimeZone(TimeZone.getTimeZone("CTT"));
        return objectMapper;
    }
}
