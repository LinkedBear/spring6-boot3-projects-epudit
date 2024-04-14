package com.linkedbear.springboot.webmvc.a_quickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickstartController {
    
    @RequestMapping("/test")
    public String demo() {
        return "test";
    }
}
