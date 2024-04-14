package com.linkedbear.spring.feature.observerd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "com.linkedbear.spring.feature.observerd",
               includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class WebMvcConfiguration {

}
