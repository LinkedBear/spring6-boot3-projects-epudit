package com.linkedbear.springboot.jdbc;

import com.linkedbear.springboot.jdbc.dao.impl.UserDaoImpl;
import com.linkedbear.springboot.jdbc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class JdbcTest1 {
    
    @Autowired
    private UserDaoImpl userDao;
    
    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setName("测试保存用户");
        user.setTel("123654789");
        userDao.save(user);
        
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
}
