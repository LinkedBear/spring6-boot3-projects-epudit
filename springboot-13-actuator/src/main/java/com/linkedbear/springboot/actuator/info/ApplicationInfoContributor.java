package com.linkedbear.springboot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationInfoContributor implements InfoContributor {
    
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName", "springboot-13-actuato123r");
        Map<String, Object> data = new HashMap<>();
        data.put("version", "1.0.0");
        builder.withDetails(data);
    }
}
