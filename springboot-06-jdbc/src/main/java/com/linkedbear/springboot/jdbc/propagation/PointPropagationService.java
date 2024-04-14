package com.linkedbear.springboot.jdbc.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointPropagationService {
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void addPoint() {
        System.out.println("addPoint 添加积分 ......");
    }
}
