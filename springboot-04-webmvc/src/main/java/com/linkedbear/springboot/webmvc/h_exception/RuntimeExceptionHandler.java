package com.linkedbear.springboot.webmvc.h_exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class RuntimeExceptionHandler {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request,
            HttpServletResponse response, RuntimeException e) {
        e.printStackTrace();
        logger.error(e.getMessage(), e);
        return "error";
    }
}
