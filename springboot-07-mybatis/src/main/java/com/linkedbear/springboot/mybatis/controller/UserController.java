package com.linkedbear.springboot.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkedbear.springboot.mybatis.entity.User;
import com.linkedbear.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/test1")
    public List<User> test1() {
        return userService.test();
    }
    
    @GetMapping("/test2")
    public String test2() {
        userService.testCache1();
        return "success";
    }
    
    @GetMapping("/test3")
    public List<User> test3() {
        return userService.testPage1();
    }
    
    @GetMapping("/test4")
    public PageInfo<User> test4(Integer pageNum, Integer pageSize) {
        return userService.testPage2(pageNum, pageSize);
    }
}
