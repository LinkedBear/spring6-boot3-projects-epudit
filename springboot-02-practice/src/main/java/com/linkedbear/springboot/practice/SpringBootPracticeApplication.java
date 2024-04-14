package com.linkedbear.springboot.practice;

import com.linkedbear.springboot.practice.bean.Person;
import com.linkedbear.springboot.practice.logging.LoggingService;
import com.linkedbear.springboot.starter.component.Cat;
import com.linkedbear.springboot.starter.component.Dog;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

@SpringBootApplication
public class SpringBootPracticeApplication {
    
//    @Value("${person.name}")
//    private String name;
    
    public static void main(String[] args) {
//        var ctx = SpringApplication.run(SpringBootPracticeApplication.class, args);
//        System.out.println(ctx.getBean(SpringBootPracticeApplication.class).name);
//        System.out.println(ctx.getBean(Person.class));
        
//        SpringApplication springApplication = new SpringApplication(SpringBootPracticeApplication.class);
//        SpringApplication springApplication = new SpringApplicationBuilder(SpringBootPracticeApplication.class).build();
//        Properties properties = new Properties();
//        properties.setProperty("server.port", "9999");
//        springApplication.setDefaultProperties(properties);
//        springApplication.run(args);
        
        SpringApplication springApplication = new SpringApplication(SpringBootPracticeApplication.class);
        springApplication.setAdditionalProfiles("sky");
        var ctx = springApplication.run(args);
//        SpringApplication springApplication = new SpringApplicationBuilder(
//                SpringBootPracticeApplication.class).profiles("sky").build();
        
//        System.out.println("rabbit是否存在：" + ctx.containsBeanDefinition("rabbit"));
//        System.out.println("turtle是否存在：" + ctx.containsBeanDefinition("turtle"));
//        System.out.println("fish是否存在：" + ctx.containsBeanDefinition("fish"));
//        System.out.println("bird是否存在：" + ctx.containsBeanDefinition("bird"));
//        System.out.println("bat是否存在：" + ctx.containsBeanDefinition("bat"));
    
//        ctx.getBean(LoggingService.class).printLog();
        
//        System.out.println(ctx.getBean(Cat.class));
//        System.out.println(ctx.getBean(Dog.class));
    }
}
