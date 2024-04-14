package com.linkedbear.springboot.webmvc.m_resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/testGet1")
    public String testGet1() {
        return "";
    }
}
