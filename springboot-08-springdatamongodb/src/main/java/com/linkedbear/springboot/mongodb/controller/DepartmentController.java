package com.linkedbear.springboot.mongodb.controller;

import com.linkedbear.springboot.mongodb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/test1")
    public String test1() {
        departmentService.save();
        return "success";
    }
}
