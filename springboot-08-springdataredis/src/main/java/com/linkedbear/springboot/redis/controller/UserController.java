package com.linkedbear.springboot.redis.controller;

import com.linkedbear.springboot.redis.dao.UserRepository;
import com.linkedbear.springboot.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/test1")
    public String test1() {
        userRepository.save(new User(1, "zhangsan", "12345"));
        userRepository.save(new User(2, "lisi", "54321"));
        userRepository.save(new User(3, "wangwu", "1234567"));
        return "success";
    }
    
    @GetMapping("/test2")
    public List<User> test2() {
        return userRepository.findAll();
    }
    
    @GetMapping("/test3")
    public List<User> test3() {
        return userRepository.findAllByName("wangwu");
    }
    
    @GetMapping("/test4")
    public String test4() {
        userRepository.deleteById(3);
        return "success";
    }
}
