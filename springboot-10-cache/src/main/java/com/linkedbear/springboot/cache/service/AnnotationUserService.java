package com.linkedbear.springboot.cache.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.linkedbear.springboot.cache.entity.User;
import com.linkedbear.springboot.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationUserService {

    @Autowired
    private UserMapper userMapper;
    
//    @Cacheable(value = "user.get", key = "#root.caches[0]")
//    @Cacheable(value = "user.get", keyGenerator = "userKeyGenerator")
//    @Cacheable(value = "user.get", key = "#id", condition = "#id % 2 == 1", unless = "#result.name.contains('jpa')")
    public User get(Integer id) {
        return userMapper.selectById(id);
    }
    
    public List<User> findAll() {
        return userMapper.selectList(null);
    }
    
    public List<User> findAllByName(String name) {
        return userMapper.selectList(Wrappers.lambdaQuery(User.class).like(User::getName, name));
    }
    
    @CachePut(value = "user.get", key = "#user.id")
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }
    
    @CacheEvict(value = "user.get", key = "#id")
    public void deleteById(Integer id) {
//        userMapper.deleteById(id);
        System.out.println("deleteById invoke ......");
    }
}
