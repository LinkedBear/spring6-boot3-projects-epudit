package com.linkedbear.spring.lifecycle.e_lifecycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class Pen4 implements InitializingBean, DisposableBean, Lifecycle {
    
    private Integer ink;
    
    private boolean running = false;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - 准备写字。。。");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - 书写完毕。。。");
    }
    
    @Override
    public void start() {
        System.out.println("Lifecycle#start - 写了一行字。。。");
        this.running = true;
    }
    
    @Override
    public void stop() {
        System.out.println("Lifecycle#stop - 写到最后一个字。。。");
        this.running = false;
    }
    
    @Override
    public boolean isRunning() {
        return running;
    }
    
    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
