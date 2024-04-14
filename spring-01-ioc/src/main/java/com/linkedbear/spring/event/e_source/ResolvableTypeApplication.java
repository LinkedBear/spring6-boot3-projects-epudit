package com.linkedbear.spring.event.e_source;

import com.linkedbear.spring.event.a_quickstart.listener.ContextRefreshedApplicationListener;
import org.springframework.core.ResolvableType;

public class ResolvableTypeApplication {
    
    public static void main(String[] args) throws Exception {
        ResolvableType resolvableType = ResolvableType.forClass(ContextRefreshedApplicationListener.class);
        System.out.println(resolvableType.getInterfaces()[0].resolveGeneric(0));
    }
}
