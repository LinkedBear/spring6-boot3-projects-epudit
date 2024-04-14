package com.linkedbear.springboot.jdbc.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPropagationService {
    
    @Autowired
    private PointPropagationService pointService;
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void register() {
        // 持久化操作 ......
        System.out.println("register 注册用户 ......");
        pointService.addPoint();
    }
}
