package com.linkedbear.spring.feature.observerd.service;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class DemoService {
    
    @Observed(name = "demo.service.insert", contextualName = "demoServiceInsertAction")
    public void insert() {
        try {
            // 模拟数据库插入操作的耗时
            Thread.sleep(ThreadLocalRandom.current().nextLong(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DemoService insert data ......");
    }
}
