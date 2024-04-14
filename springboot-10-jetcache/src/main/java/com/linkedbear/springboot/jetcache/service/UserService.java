package com.linkedbear.springboot.jetcache.service;

import com.linkedbear.springboot.jetcache.entity.User;
import com.linkedbear.springboot.jetcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public User get(Integer id) {
        return userMapper.selectById(id);
    }
    
    public List<User> findAll() {
        return userMapper.selectList(null);
    }
    
    public List<User> findAllByName(String name) {
        return userMapper.selectList(lambdaQuery(User.class).like(User::getName, name));
    }
}
