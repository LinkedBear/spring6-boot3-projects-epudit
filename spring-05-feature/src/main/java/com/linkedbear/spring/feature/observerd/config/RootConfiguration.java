package com.linkedbear.spring.feature.observerd.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.linkedbear.spring.feature.observerd",
               excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class RootConfiguration {
    
    @Bean
    public ObservedAspect observedAspect(DemoObservedHandler demoObservedHandler) {
        ObservationRegistry registry = ObservationRegistry.create();
        registry.observationConfig().observationHandler(demoObservedHandler);
        return new ObservedAspect(registry);
    }
}
