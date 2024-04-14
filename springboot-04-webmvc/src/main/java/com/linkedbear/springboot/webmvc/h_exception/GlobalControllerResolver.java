package com.linkedbear.springboot.webmvc.h_exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerResolver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e, Model model) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "出现计算错误");
        return "error/errorPage";
    }
    
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e, Model model) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "出现运行时异常");
        return "error/errorPage";
    }
    
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "出现预期之外的错误");
        return "error/errorPage";
    }
    
//    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request,
            HttpServletResponse response, RuntimeException e) {
        e.printStackTrace();
        logger.error(e.getMessage(), e);
        return "error";
    }
}
