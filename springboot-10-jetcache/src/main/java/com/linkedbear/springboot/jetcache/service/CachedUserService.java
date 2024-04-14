package com.linkedbear.springboot.jetcache.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.template.QuickConfig;
import com.linkedbear.springboot.jetcache.entity.User;
import com.linkedbear.springboot.jetcache.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

@Service
public class CachedUserService {
    
    @Autowired
    private CacheManager cacheManager;
    
    private Cache<String, User> cache;
    
    @Autowired
    private UserMapper userMapper;
    
    @PostConstruct
    public void init() {
        QuickConfig config = QuickConfig.newBuilder("user-cache")
                .cacheType(CacheType.BOTH)
                .expire(Duration.ofMinutes(1)).build();
        this.cache = this.cacheManager.getOrCreateCache(config);
    }
    
    public User get(Integer id) {
        String cacheKey = "getUser." + id;
        return cache.computeIfAbsent(cacheKey, key -> {
            return userMapper.selectById(id);
        });
    }
    
    public List<User> findAll() {
        return userMapper.selectList(null);
    }
    
    public List<User> findAllByName(String name) {
        return userMapper.selectList(lambdaQuery(User.class).like(User::getName, name));
    }
    
    public User update(User user) {
        userMapper.updateById(user);
        String cacheKey = "getUser." + user.getId();
        cache.put(cacheKey, user);
        return user;
    }
    
    public void deleteById(Integer id) {
//        userMapper.deleteById(id);
        System.out.println("deleteById invoke ......");
        String cacheKey = "getUser." + id;
        cache.remove(cacheKey);
    }
}
