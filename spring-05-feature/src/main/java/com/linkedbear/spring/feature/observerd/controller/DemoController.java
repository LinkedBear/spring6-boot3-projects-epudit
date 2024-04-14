package com.linkedbear.spring.feature.observerd.controller;

import com.linkedbear.spring.feature.observerd.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    private DemoService demoService;
    
    @GetMapping("/insert")
    public String insert() {
        demoService.insert();
        return "success";
    }
}
