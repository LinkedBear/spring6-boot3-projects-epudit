package com.linkedbear.spring.basic_dl.d_withanno.config;

import com.linkedbear.spring.basic_di.a_quickstart_set.bean.Cat;
import com.linkedbear.spring.basic_dl.d_withanno.bean.Black;
import com.linkedbear.spring.basic_dl.d_withanno.bean.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WithAnnoConfiguration {

    @Bean
    public Black black() {
        return new Black();
    }
    
    @Bean
    public Red red() {
        return new Red();
    }
    
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
