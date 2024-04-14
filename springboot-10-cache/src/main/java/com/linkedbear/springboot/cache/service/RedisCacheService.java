package com.linkedbear.springboot.cache.service;

import com.linkedbear.springboot.cache.entity.User;
import com.linkedbear.springboot.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Autowired
    private UserMapper userMapper;
    
    @Cacheable(value = "getName")
    public String getName(Integer i) {
        System.out.println("getName invoke ......");
        return "name" + i;
    }
    
    @Cacheable(value = "getUser", cacheManager = "userCacheManager")
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }
}
