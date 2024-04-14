package com.linkedbear.spring00.h_decorator.servlet;

import com.linkedbear.spring00.h_decorator.factory.BeanFactory;
import com.linkedbear.spring00.h_decorator.service.DemoService;
import com.linkedbear.spring00.h_decorator.service.decorator.DemoServiceDecorator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo8")
public class DemoServlet8 extends HttpServlet {
    
    DemoService demoService = new DemoServiceDecorator((DemoService) BeanFactory.getBean("demoService"));
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("bearbear", 666);
        demoService.subtract("bearbear", 666);
    }
}
