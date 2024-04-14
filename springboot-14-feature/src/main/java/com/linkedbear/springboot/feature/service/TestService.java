package com.linkedbear.springboot.feature.service;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.Reflective;

public class TestService {
    
//    @Reflective
    public TestService() {
    
    }
    
//    @Reflective
    public void test() {
        System.out.println("TestService test ......");
    }
    
    public static class TestServiceRuntimeHints implements RuntimeHintsRegistrar {
        
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            try {
                hints.reflection().registerConstructor(TestService.class.getConstructor(), ExecutableMode.INVOKE);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
