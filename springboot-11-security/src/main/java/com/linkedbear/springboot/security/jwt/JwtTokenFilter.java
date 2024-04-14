package com.linkedbear.springboot.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.PublicKey;

@Component
public class JwtTokenFilter implements Filter {
    
    private PublicKey publicKey;
    
    public JwtTokenFilter() {
        this.publicKey = RsaUtils.getPublicKey("jwt_rsa.pub");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            // 解析jwt令牌
            String jwt = req.getHeader(JwtUtils.JWT_HEADER);
            // 忽略oauth2.0的Bearer令牌
            if (StringUtils.hasText(jwt) && !jwt.startsWith("Bearer")) {
                TokenPayload payload = JwtUtils.parseToken(jwt, publicKey);
                User user = payload.getUser();
                // 重要：设置用户信息
                SecurityContextHolder.setContext(new SecurityContextImpl(
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())));
            } else {
                // 没有获取到jwt信息，则存入一个空用户信息，代表未登录
                SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("jwt令牌已过期！");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (JwtException e) {
            e.printStackTrace();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("解析jwt令牌失败！");
            response.getWriter().flush();
            response.getWriter().close();
        } finally {
            SecurityContextHolder.clearContext();
        }
    }
}
