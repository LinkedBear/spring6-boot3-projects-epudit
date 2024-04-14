package com.linkedbear.springboot.practice.failure;

/**
 * 不合法的端口异常
 */
public class IllegalPortException extends RuntimeException {
    
    private int port;
    
    public IllegalPortException(int port) {
        this.port = port;
    }
    
    public int getPort() {
        return port;
    }
}
