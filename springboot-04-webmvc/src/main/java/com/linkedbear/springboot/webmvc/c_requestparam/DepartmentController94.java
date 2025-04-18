package com.linkedbear.springboot.webmvc.c_requestparam;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class DepartmentController94 {
    
    private List<Department> departmentList = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
    }
    
    @RequestMapping("/department/list")
    public String list(Model model) {
        model.addAttribute("deptList", this.departmentList);
        return "dept/deptList";
    }
    
    @RequestMapping("/department/list2")
    public String list2(ModelMap modelMap) {
        modelMap.put("deptList", this.departmentList);
        return "dept/deptList";
    }
    
    @RequestMapping("/department/list3")
    public ModelAndView list3(ModelAndView mav) {
        mav.addObject("deptList", this.departmentList);
        mav.setViewName("dept/deptList");
        return mav;
    }
    
    @RequestMapping("/department/list4")
    public String list4(HttpServletRequest request) {
        request.setAttribute("deptList", this.departmentList);
        return "dept/deptList";
    }
}
