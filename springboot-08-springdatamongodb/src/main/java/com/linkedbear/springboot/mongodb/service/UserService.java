package com.linkedbear.springboot.mongodb.service;

import com.linkedbear.springboot.mongodb.dao.UserRepository;
import com.linkedbear.springboot.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mongoUserService")
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(rollbackFor = Exception.class)
    public void saveAndPrint() {
        userRepository.save(new User().setName("save").setAge(20));
        int i = 1 / 0;
        System.out.println(userRepository.findAll());
    }
}