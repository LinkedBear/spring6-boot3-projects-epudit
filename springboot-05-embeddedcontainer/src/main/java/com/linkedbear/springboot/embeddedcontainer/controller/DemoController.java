package com.linkedbear.springboot.embeddedcontainer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
