package com.linkedbear.springboot.jdbc.controller;

import com.linkedbear.springboot.jdbc.propagation.UserPropagationService;
import com.linkedbear.springboot.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/tx1")
    public String tx1() {
        userService.saveAndQuery();
        return "success";
    }
    
    @GetMapping("/tx2")
    public String tx2() {
        userService.saveAndQuery2();
        return "success";
    }
    
    @GetMapping("/tx3")
    public String tx3() {
        userService.saveAndQuery3();
        return "success";
    }
    
    @Autowired
    private UserPropagationService userPropagationService;
    
    @GetMapping("/tx4")
    public String tx4() {
        userPropagationService.register();
        return "success";
    }
}
