package com.linkedbear.springboot.redis.dao;

import com.linkedbear.springboot.redis.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ListCrudRepository<User, Integer> {
    
    List<User> findAllByName(String name);
    
    User findByNameAndTel(String name, String tel);
}
