package com.linkedbear.springboot.practice.failure;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

public class ChinesePortInUseFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException> {
    
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis("当前端口" + cause.getPort() + "被占用！",
                "检查" + cause.getPort() + "为什么被占用，并停止占用的程序。", rootFailure);
    }
}
