package com.linkedbear.springboot.embeddedcontainer.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedContainerConfiguration {
    
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webserverCustomizer() {
        return factory -> {
//            factory.setPort(9090);
        };
    }
    
    @Bean
    public ServletWebServerFactory httpServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        Connector connector = new Connector(new Http11NioProtocol());
        connector.setPort(8080);
        factory.addAdditionalTomcatConnectors(connector);
        return factory;
    }
}
