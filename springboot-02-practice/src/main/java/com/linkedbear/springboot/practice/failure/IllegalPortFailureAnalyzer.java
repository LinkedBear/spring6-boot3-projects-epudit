package com.linkedbear.springboot.practice.failure;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class IllegalPortFailureAnalyzer extends AbstractFailureAnalyzer<IllegalPortException> {
    
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, IllegalPortException cause) {
        return new FailureAnalysis("检测到不合法的端口：" + cause.getPort(),
                "请使用10000以内的端口号", cause);
    }
}
