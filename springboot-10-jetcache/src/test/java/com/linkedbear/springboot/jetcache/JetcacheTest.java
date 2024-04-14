package com.linkedbear.springboot.jetcache;

import com.linkedbear.springboot.jetcache.entity.User;
import com.linkedbear.springboot.jetcache.service.AnnotationUserService;
import com.linkedbear.springboot.jetcache.service.CachedUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JetcacheTest {
    
    @Autowired
    private CachedUserService userService;
    
    @Test
    public void test1() {
    	userService.get(1);
    	userService.get(1);
    	userService.get(1);
    }
    
    @Test
    public void test2() {
        User user = userService.get(1);
        // 使用临时对象，防止有误解
        User temp = new User();
        BeanUtils.copyProperties(user, temp);
        temp.setName(temp.getName() + "-jetcache");
        userService.update(temp);
        User user1 = userService.get(1);
        System.out.println(user == user1);
        System.out.println(temp == user1);
    }
    
    @Test
    public void test3() {
        User user = userService.get(1);
        userService.deleteById(1);
        User user1 = userService.get(1);
        System.out.println(user == user1);
    }
    
    @Autowired
    private AnnotationUserService annotationUserService;
    
    @Test
    public void test4() {
        User user1 = annotationUserService.get(6);
        User user2 = annotationUserService.get(6);
        System.out.println(user1 == user2);
    }
    
    @Test
    public void test5() {
        User user = annotationUserService.get(1);
        user.setName("mybatis test jetcache");
        annotationUserService.update(user);
        User user2 = annotationUserService.get(1);
        System.out.println(user == user2);
    }
    
    @Test
    public void test6() {
        User user1 = annotationUserService.get(1);
        User user2 = annotationUserService.get(1);
        annotationUserService.deleteById(1);
        User user3 = annotationUserService.get(1);
        System.out.println(user1 == user3);
    }
}
