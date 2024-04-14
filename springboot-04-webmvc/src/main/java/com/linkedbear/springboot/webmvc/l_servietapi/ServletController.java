package com.linkedbear.springboot.webmvc.l_servietapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ServletController {
    
    @RequestMapping("/demo")
    public void demo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求转发
        request.getRequestDispatcher(request.getContextPath() + "/department/list").forward(request, response);
        // 重定向
        response.sendRedirect(request.getContextPath() + "/department/list");
    }
    
    @RequestMapping("/forward")
    public String forward() {
        return "forward:/department/list";
    }
    
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/department/list";
    }
}
