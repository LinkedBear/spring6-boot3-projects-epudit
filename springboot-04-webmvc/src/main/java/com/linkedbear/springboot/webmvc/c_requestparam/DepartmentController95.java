package com.linkedbear.springboot.webmvc.c_requestparam;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class DepartmentController95 {
    
    private List<Department> departmentList = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
    }
    
    @RequestMapping("/department95/list1")
    public String list1(String name, Model model) {
        Stream<Department> stream = this.departmentList.stream();
        if (StringUtils.hasText(name)) {
            stream = stream.filter(i -> i.getName().contains(name));
        }
        model.addAttribute("deptList", stream.collect(Collectors.toList()));
        return "dept/deptList";
    }
    
    @RequestMapping("/department95/list2")
    public String list2(Department department, Model model) {
        Stream<Department> stream = this.departmentList.stream();
        if (StringUtils.hasText(department.getName())) {
            stream = stream.filter(i -> i.getName().contains(department.getName()));
        }
        model.addAttribute("deptList", stream.collect(Collectors.toList()));
        return "dept/deptList";
    }
    
    @RequestMapping("/department95/list3")
    public String list3(@RequestParam(value = "dept_name", required = false, defaultValue = "") String name, Model model) {
        Stream<Department> stream = this.departmentList.stream();
        if (StringUtils.hasText(name)) {
            stream = stream.filter(i -> i.getName().contains(name));
        }
        model.addAttribute("deptList", stream.collect(Collectors.toList()));
        model.addAttribute("name", name);
        return "dept/deptList";
    }
}
