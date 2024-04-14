package com.linkedbear.springboot.webmvc.c_requestparam;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class UserController96 {
    
    private List<Department> departmentList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    
    @PostConstruct
    public void init() throws Exception {
        Department dept1 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门1", "123321");
        departmentList.add(dept1);
        Department dept2 = new Department(UUID.randomUUID().toString().replaceAll("-", ""), "测试部门2", "1234567");
        departmentList.add(dept2);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user1 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "zhangsan", "张三", dateFormat.parse("2023-01-01"), null, dept1);
        userList.add(user1);
        User user2 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "lisi", "李四", dateFormat.parse("2023-02-02"), null, dept1);
        userList.add(user2);
        User user3 = new User(UUID.randomUUID().toString().replaceAll("-", ""),
                "wangwu", "王五", dateFormat.parse("2023-03-03"), null, dept2);
        userList.add(user3);
    }
    
    @RequestMapping("/user96/list")
    public String list(String username, Model model) {
        Stream<User> stream = this.userList.stream();
        if (StringUtils.hasText(username)) {
            stream = stream.filter(i -> i.getUsername().contains(username));
        }
        model.addAttribute("userList", stream.collect(Collectors.toList()));
        return "user/userList";
    }
    
    @RequestMapping("/user96/edit")
    public String edit(String id, Model model) {
        model.addAttribute("user", this.userList.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null));
        model.addAttribute("deptList", this.departmentList);
        return "user/userInfo";
    }
    
    @RequestMapping(value = "/user96/save", method = RequestMethod.POST)
    public String save(User user) {
        System.out.println(user);
        return "redirect:/user96/list";
    }
    
    @RequestMapping("/user96/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") String[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }
    
    @RequestMapping("/user96/batchUpdate")
    public String batchUpdate(UsersVO vo) {
        System.out.println(Arrays.toString(vo.getUsers()));
        return "redirect:/user96/list";
    }
    
    @GetMapping("/user96/get")
    @ResponseBody
    public User get() {
        return userList.get(0);
    }
}
