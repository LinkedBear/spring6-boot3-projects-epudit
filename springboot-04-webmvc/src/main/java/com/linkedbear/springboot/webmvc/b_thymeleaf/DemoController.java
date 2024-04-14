package com.linkedbear.springboot.webmvc.b_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DemoController {
    
    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
    
    @GetMapping("/basic")
    public String basic(Model model) {
        model.addAttribute("h1content", "动态h1标签内容");
        model.addAttribute("h2html", "这是一段组合的html <u>h3标签内的下划线文本</u>");
        
        model.addAttribute("springWidth", 200);
        model.addAttribute("springHeight", 100);
        
        model.addAttribute("dynamicAttrUrl", "https://docs.spring.io/spring-framework/reference/_images/singleton.png");
        model.addAttribute("dynamicAttrWidth", "200");
        
        User user = new User();
        user.setName("haha");
        user.setAge(18);
        model.addAttribute("user", user);
        
        model.addAttribute("price", 12345.678);
        model.addAttribute("lowertext", "thymeleaf nice");
        model.addAttribute("nowTime", new Date());
        model.addAttribute("list", List.of("aaa", "bbb", "ddd", "ccc"));
        return "demo-basic";
    }
}
