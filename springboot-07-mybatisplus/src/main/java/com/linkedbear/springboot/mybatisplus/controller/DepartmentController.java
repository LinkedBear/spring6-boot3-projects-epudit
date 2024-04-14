package com.linkedbear.springboot.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.linkedbear.springboot.mybatisplus.entity.Department;
import com.linkedbear.springboot.mybatisplus.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/test1")
    public List<Department> test1() {
        return departmentService.list();
    }
    
    @GetMapping("/test2")
    public Long test2() {
        return departmentService.count();
    }
    
    @GetMapping("/test3")
    public List<Department> test3() {
        return departmentService.list(Wrappers.<Department>query().like("name", "分公司"));
    }
    
    @GetMapping("/test4")
    public List<Department> test4() {
        return departmentService.list(Wrappers.lambdaQuery(Department.class)
                .like(Department::getName, "分公司"));
    }
    
    @GetMapping("/test5")
    public List<Department> test5() {
        return departmentService.list(Wrappers.lambdaQuery(Department.class)
                .select(Department::getId, Department::getName));
    }
    
    @GetMapping("/test6")
    public Department test6() {
        return departmentService.getOne(Wrappers.query(Department.class).select("max(id) as id"));
    }
    
    @GetMapping("/test7")
    public List<Department> test7(Department qo) {
        LambdaQueryWrapper<Department> wrapper = Wrappers.lambdaQuery(Department.class);
        if (qo.getId() != null) {
            wrapper.eq(Department::getId, qo.getId());
        }
        wrapper.like(StringUtils.hasText(qo.getName()), Department::getName, qo.getName());
        return departmentService.list(wrapper);
    }
}
