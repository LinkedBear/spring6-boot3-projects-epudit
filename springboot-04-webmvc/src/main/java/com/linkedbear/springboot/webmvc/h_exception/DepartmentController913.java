package com.linkedbear.springboot.webmvc.h_exception;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/department913")
public class DepartmentController913 {
    
    private List<Department> departmentList = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
    }
    
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        int i = 1 / 0;
        model.addAttribute("deptList", departmentList);
        return "dept/deptList";
    }
    
    @RequestMapping("/list2")
    public String list2(HttpServletRequest request, Model model) {
        throw new RuntimeException("显式抛出异常");
    }
    
    @RequestMapping("/list3")
    public String list3(HttpServletRequest request, Model model) {
        Object obj = null;
        obj.toString();
        model.addAttribute("deptList", departmentList);
        return "dept/deptList";
    }
    
//    @ExceptionHandler(ArithmeticException.class)
//    @ResponseBody
    public String handleArithmeticException(ArithmeticException e, Model model) {
        e.printStackTrace();
//        return "请求出现错误，请稍后再试";
        model.addAttribute("errorMessage", e.getMessage());
        return "error/errorPage";
    }
}
