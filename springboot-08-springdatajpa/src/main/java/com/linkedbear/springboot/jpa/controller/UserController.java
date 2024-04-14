package com.linkedbear.springboot.jpa.controller;

import com.linkedbear.springboot.jpa.dao.UserDao;
import com.linkedbear.springboot.jpa.entity.User;
import com.linkedbear.springboot.jpa.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDao userDao;
    
    @GetMapping("/test1")
    public List<User> test1() {
        return userDao.findAll();
    }
    
    @GetMapping("/test2")
    public User test2() {
        return userService.save();
    }
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @GetMapping("/test3")
    public List<User> test3() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from User").getResultList();
    }
    
    @GetMapping("/test4")
    public List<User> test4() {
        User example = new User();
        example.setName("my");
        
        return userDao.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> criterias = new ArrayList<>();
            criterias.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + example.getName() + "%"));
            return criteriaBuilder.and(criterias.toArray(new Predicate[0]));
        });
    }
}
