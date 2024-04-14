package com.linkedbear.springboot.security.config;

import com.linkedbear.springboot.security.filter.ResourceAuthorizationFilter;
import com.linkedbear.springboot.security.jwt.JwtTokenFilter;
import com.linkedbear.springboot.security.jwt.JwtUtils;
import com.linkedbear.springboot.security.jwt.RsaUtils;
import com.linkedbear.springboot.security.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import java.security.PrivateKey;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, proxyTargetClass = true)
public class WebSecurityConfiguration {
    
    private PrivateKey privateKey;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserService userService, JdbcTemplate jdbcTemplate,
            ResourceAuthorizationFilter resourceAuthorizationFilter, JwtTokenFilter jwtTokenFilter) throws Exception {
        /*
        // 限制所有接口都需要认证后访问
        http.authorizeHttpRequests(i -> {
            i.anyRequest().authenticated();
        });
         */
        // 开启表单登录功能，不进行任何其他定制
        // http.formLogin(i -> {});
        // 开启表单登录功能，并指定登录成功和失败后的逻辑
        /*
        http.formLogin(i -> {
            i.successHandler((request, response, authentication) -> {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("登录成功");
            }).failureHandler((request, response, exception) -> {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("登录失败");
                exception.printStackTrace();
            });
        });
         */
        // 限制/api开头的接口需要拥有admin角色，其余接口需要认证后访问
        /*
        http.authorizeHttpRequests(i -> {
            i.requestMatchers("/api/**").hasRole("admin")
                    .anyRequest().authenticated();
        });
         */
        // 限制/api/test接口需要拥有/api/test权限
        /*
        http.authorizeHttpRequests(i -> {
            i.requestMatchers("/api/test").hasAuthority("/api/test")
                    .anyRequest().authenticated();
        });
         */
        // 引入用户管理机制
        // http.userDetailsService(userDetailsService());
        // 使用自定义的UserService完成基于数据库的用户管理
        http.userDetailsService(userService);
        // 关闭CSRF
        http.csrf(i -> i.disable());
        // 使用cookie存放CSRF标识
        /*
        XorCsrfTokenRequestAttributeHandler delegate = new XorCsrfTokenRequestAttributeHandler();
        http.csrf(i -> i.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .csrfTokenRequestHandler(delegate::handle));
         */
        // 开启“记住我”功能
        http.rememberMe(i -> {
            JdbcTokenRepositoryImpl remembermeRepository = new JdbcTokenRepositoryImpl();
            remembermeRepository.setJdbcTemplate(jdbcTemplate);
            i.tokenRepository(remembermeRepository).userDetailsService(userService);
        });
        // 默认的权限控制只检查是否已登录
        // http.authorizeHttpRequests(i -> i.anyRequest().authenticated());
        // 默认的权限控制只检查是否已登录，对特定请求路径进行放行
        http.authorizeHttpRequests(i -> i.requestMatchers("/login", "logout", "/refreshToken").permitAll()
                .anyRequest().authenticated());
        // 注入自定义过滤器，连接数据库动态鉴权
        http.addFilterAfter(resourceAuthorizationFilter, AuthorizationFilter.class);
        // 开启表单登录功能，设置认证成功后响应jwt信息
        this.privateKey = RsaUtils.getPrivateKey("jwt_rsa");
        http.formLogin(i -> {
            i.successHandler((request, response, authentication) -> {
                User user = (User) authentication.getPrincipal();
                // 从authentication中取到User，生成jwt并写入response
                JwtUtils.writeJwtToken(response, user, privateKey, 30, 3600);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("登录成功");
            }); // 省略failureHandler ......
        });
        // 设置jwt令牌的解析过滤器执行时机比AnonymousAuthenticationFilter靠前
        http.addFilterBefore(jwtTokenFilter, AnonymousAuthenticationFilter.class);
        // 设置无状态session
        http.sessionManagement(i -> i.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userManager = new InMemoryUserDetailsManager();
        userManager.createUser(User.withUsername("xiaoshuai")
                .password(passwordEncoder().encode("123456")).roles("admin").build());
        userManager.createUser(User.withUsername("xiaoming")
                .password(passwordEncoder().encode("654321")).roles("user").build());
        userManager.createUser(User.withUsername("boss")
                .password(passwordEncoder().encode("123456")).roles("admin", "manager").build());
        return userManager;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
