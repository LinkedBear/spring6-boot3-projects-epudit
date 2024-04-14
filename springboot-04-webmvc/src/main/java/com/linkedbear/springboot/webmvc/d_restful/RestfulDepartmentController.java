package com.linkedbear.springboot.webmvc.d_restful;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class RestfulDepartmentController {
    
    private List<Department> departmentList = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
    }
    
    @GetMapping("/findAll")
    public List<Department> findAll() {
        return departmentList;
    }
    
    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") String id) {
        return departmentList.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null);
    }
    
    @PostMapping("/")
    public void save(Department department) {
        departmentList.add(department);
    }
    
    @PutMapping("/{id}")
    public void update(Department department, @PathVariable("id") String id) {
        departmentList.stream().filter(i -> i.getId().equals(id)).findAny().ifPresent(i -> {
            // 将修改的department属性复制到原来的数据，即相当于修改
            BeanUtils.copyProperties(department, i, "id");
        });
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        departmentList.stream().filter(i -> i.getId().equals(id)).findAny().ifPresent(i -> departmentList.remove(i));
    }
    
    @PostMapping("/saveJson")
    public String saveJson(@RequestBody Department department) {
        System.out.println(department);
        departmentList.add(department);
        return "success";
    }
}
