package com.linkedbear.springboot.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

@Configuration
public class JdbcConfiguration {
    
    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }
}
