package com.linkedbear.springboot.practice.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);
    
    public void printLog() {
        logger.debug("这是一条debug日志");
        logger.info("这是一条info带参数的日志：{}", "我是参数");
        logger.warn("这是一条warn日志");
        logger.error("这是一条error带异常信息的日志", new NullPointerException());
    }
}
