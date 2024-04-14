package com.linkedbear.springboot.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
    
    @Autowired
    private MeterRegistry meterRegistry;
    
    private Counter counter;
    
    @PostConstruct
    public void init() {
        counter = meterRegistry.counter("demo.request");
    }
    
    @GetMapping("/demo")
    public String demo() {
        counter.increment();
        return "demo";
    }
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("https://www.baidu.com", String.class);
    }
}
