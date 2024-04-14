package com.linkedbear.springboot.webmvc.l_servietapi;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/department103")
public class DepartmentController103 {
    
    private List<Department> departmentList = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
    }
    
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model, String dept_name,
            @RequestParam("dept_name") String name, @ModelAttribute("dept_name") String deptName) {
        System.out.println("使用HttpServletRequest获取：" + request.getParameter("dept_name"));
        System.out.println("使用Model对象获取：" + model.getAttribute("dept_name"));
        System.out.println("使用同名参数：" + dept_name);
        System.out.println("使用@RequestParam：" + name);
        System.out.println("使用@ModelAttribute：" + deptName);
        model.addAttribute("deptList", departmentList);
        return "dept/deptList";
    }
    
    @ModelAttribute("publicMessage")
    public String publicMessage() {
        return "publicMessage-hahaha";
    }
    
    @ModelAttribute("dept_name")
    public String processName(@RequestParam("dept_name") String name) {
        System.out.println(name);
        return "dept" + name;
    }
}
