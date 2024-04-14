package com.linkedbear.springboot.micrometer.controller;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ObservationRegistry registry;
    
    @GetMapping("/test")
    public String test() {
        return Observation.createNotStarted("test.resttemplate.invoke", registry)
                .contextualName("test-resttemplate-invoke-action").observe(() -> {
                    logger.info("TestController invoke ......");
                    String result = restTemplate.getForObject("http://localhost:8080/demo", String.class);
                    logger.info("服务端响应数据：" + result);
                    logger.info("TestController finish ......");
                    return result;
                });
    }
}
