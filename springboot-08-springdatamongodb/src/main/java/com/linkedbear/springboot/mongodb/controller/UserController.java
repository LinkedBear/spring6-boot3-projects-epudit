package com.linkedbear.springboot.mongodb.controller;

import com.linkedbear.springboot.mongodb.dao.UserRepository;
import com.linkedbear.springboot.mongodb.entity.User;
import com.linkedbear.springboot.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/test1")
    public String test1() {
        userRepository.save(new User().setName("zhangsan").setAge(18));
        userRepository.save(new User().setName("lisi").setAge(22));
        userRepository.save(new User().setName("wangwu").setAge(36));
        return "success";
    }
    
    @GetMapping("/test2")
    public List<User> test2() {
        return userRepository.findAll();
    }
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @GetMapping("/test3")
    public String test3() {
        mongoTemplate.save(new User().setName("template").setAge(12));
        return "success";
    }
    
    @GetMapping("/test4")
    public String test4() {
        User user = new User().setName("template").setAge(12);
        User userWithId = mongoTemplate.insert(User.class).one(user);
        System.out.println(user);
        System.out.println(userWithId);
        System.out.println(user == userWithId);
        return "success";
    }
    
    @GetMapping("/test5")
    public String test5() {
        Optional<User> op = userRepository.findById("65a7b928c7d27731f7cb3c55");
        op.ifPresent(user -> {
            user.setName("template");
            user.setAge(60);
            userRepository.save(user);
        });
        userRepository.findById("65a7b928c7d27731f7cb3c55").ifPresent(System.out::println);
        return "success";
    }
    
    @GetMapping("/test6")
    public String test6() {
        User temp = new User().setAge(20);
        // 不常用的方式
        mongoTemplate.update(User.class).matching(Criteria.where("name").is("template"))
                .replaceWith(temp).as(User.class).findAndReplaceValue();
        userRepository.findById("65a7b928c7d27731f7cb3c55").ifPresent(System.out::println);
        // 相对常用的方式
        mongoTemplate.updateFirst(Query.query(Criteria.where("id").is("65a7b928c7d27731f7cb3c55")),
                Update.update("age", 200).set("name", "mongo"), User.class);
        userRepository.findById("65a7b928c7d27731f7cb3c55").ifPresent(System.out::println);
        return "success";
    }
    
    @GetMapping("/test7")
    public String test7() {
        userRepository.deleteById("65a7b928c7d27731f7cb3c55");
        userRepository.findById("65a7b928c7d27731f7cb3c55").ifPresent(System.out::println);
        return "success";
    }
    
    @GetMapping("/test8")
    public String test8() {
        System.out.println("userRepository.findAll(): " + userRepository.findAll());
        System.out.println("order by: " + userRepository.findAll(Sort.by(Sort.Order.desc("age"))));
        
        System.out.println("mongoTemplate.find: " + mongoTemplate.find(Query.query(Criteria.where("age").lt(18)), User.class));
        System.out.println("mongoTemplate.findById: " + mongoTemplate.findById("62f0f24e618cfd7eb146b14c", User.class));
        return "success";
    }
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/test9")
    public String test9() {
        userService.saveAndPrint();
        return "success";
    }
}
