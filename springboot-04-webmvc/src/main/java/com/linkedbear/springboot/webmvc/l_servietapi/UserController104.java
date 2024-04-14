package com.linkedbear.springboot.webmvc.l_servietapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/user104")
@CrossOrigin
public class UserController104 {
    
    @PostMapping("/batchDelete")
    public String batchDelete(@RequestParam("ids[]") String[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }
}
