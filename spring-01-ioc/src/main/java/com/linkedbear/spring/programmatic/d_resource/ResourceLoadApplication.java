package com.linkedbear.spring.programmatic.d_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class ResourceLoadApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("/resource/dog.txt");
        FileSystemResource fileSystemResource = new FileSystemResource("D:/dog.txt");
        UrlResource urlResource = new UrlResource("file:D:/dog.txt");
        UrlResource htmlResource = new UrlResource("https://spring.io/projects/spring-boot/");
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        Resource classpathResource = ctx.getResource("classpath:resource/dog.txt");
        Resource filesystemResource = ctx.getResource("D:/dog.txt");
        // 加载指定路径下的所有文件
        Resource[] dirResources = ctx.getResources("classpath:resource/*");
        // 加载类路径下的所有txt文件
        Resource[] alltxtResources = ctx.getResources("classpath:/**/*.txt");
    }
}
