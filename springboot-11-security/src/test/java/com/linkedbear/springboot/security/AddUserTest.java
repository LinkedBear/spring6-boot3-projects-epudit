package com.linkedbear.springboot.security;

import com.linkedbear.springboot.security.entity.User;
import com.linkedbear.springboot.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AddUserTest {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("xiaoshuai");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setName("小帅");
        user.setTel("123456789");
        user.setRoles("admin");
        userMapper.insert(user);
        
        user = new User();
        user.setUsername("xiaoming");
        user.setPassword(passwordEncoder.encode("654321"));
        user.setName("小明");
        user.setTel("987654321");
        user.setRoles("user");
        userMapper.insert(user);
        
        user = new User();
        user.setUsername("boss");
        user.setPassword(passwordEncoder.encode("111111"));
        user.setName("老板");
        user.setTel("147852369");
        user.setRoles("admin,manager");
        userMapper.insert(user);
    }
}