package com.linkedbear.springboot.security.filter;

import com.linkedbear.springboot.security.entity.Resource;
import com.linkedbear.springboot.security.mapper.ResourceMapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ResourceAuthorizationFilter implements Filter {
    
    @Autowired
    private ResourceMapper resourceMapper;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在继续向后调用过滤器链之前，连接数据库判断是否当前登录人是否允许访问
        HttpServletRequest req = (HttpServletRequest) request;
        // 首先判断当前请求是否在限制访问的列表中
        List<String> resources = resourceMapper.selectList(null).stream().map(Resource::getPermission).toList();
        String uri = req.getRequestURI();
        if (!resources.contains(uri)) {
            chain.doFilter(request, response);
            return;
        }
        // 在限制访问的列表中，需要鉴权
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails.getAuthorities().stream().anyMatch(i -> i.getAuthority().equals(uri))) {
            chain.doFilter(request, response);
            return;
        }
        throw new AccessDeniedException("权限不足");
    }
}
