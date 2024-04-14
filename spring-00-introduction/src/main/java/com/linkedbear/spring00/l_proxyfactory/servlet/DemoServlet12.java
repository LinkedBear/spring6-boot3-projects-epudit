package com.linkedbear.spring00.l_proxyfactory.servlet;

import com.linkedbear.spring00.l_proxyfactory.factory.BeanFactory;
import com.linkedbear.spring00.l_proxyfactory.service.DemoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo12")
public class DemoServlet12 extends HttpServlet {
    
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("bearbear", 666);
        demoService.subtract("bearbear", 666);
    }
}
