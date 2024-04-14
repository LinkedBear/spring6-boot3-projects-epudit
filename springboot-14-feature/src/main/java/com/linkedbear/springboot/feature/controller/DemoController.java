package com.linkedbear.springboot.feature.controller;

import com.linkedbear.springboot.feature.service.DemoService;
import com.linkedbear.springboot.feature.service.TestService;
import io.micrometer.observation.annotation.Observed;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ImportRuntimeHints(TestService.TestServiceRuntimeHints.class)
@RegisterReflectionForBinding(TestService.class)
public class DemoController {
    
    @Autowired
    private DemoService demoService;
    
    @GetMapping("/demo")
    @Observed(name = "provider.controller.demo", contextualName = "provider-demo-controller-demo")
    public String demo() {
        return "demo";
    }
    
    @GetMapping("/test")
    public String test() {
        demoService.test();
        return "test";
    }
    
    @GetMapping("/testReflect")
    public String testReflect() {
        String clz = "com.linkedbear.springboot.feature.service.TestService";
        try {
            Class<?> clazz = Class.forName(clz);
            Object instance = clazz.newInstance();
            clazz.getMethod("test").invoke(instance);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
        return "reflect";
    }
}
