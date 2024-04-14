package com.linkedbear.springboot.actuator.health;

import com.linkedbear.springboot.starter.component.Cat;
import com.linkedbear.springboot.starter.component.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class AnimalHealthIndicator extends AbstractHealthIndicator {
    
    @Autowired(required = false)
    private Cat cat;
    
    @Autowired(required = false)
    private Dog dog;
    
    @Override
    protected void doHealthCheck(Health.Builder builder) {
        if (cat == null) {
            builder.down();
            builder.withDetail("cat", "null");
        }
        if (dog == null) {
            builder.down();
            builder.withDetail("dog", "null");
        }
        ReflectionUtils.doWithFields(cat.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (ReflectionUtils.getField(field, cat) == null) {
                builder.down();
                builder.withDetail("cat." + field.getName(), "null");
            }
        });
        ReflectionUtils.doWithFields(dog.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (ReflectionUtils.getField(field, dog) == null) {
                builder.down();
                builder.withDetail("dog." + field.getName(), "null");
            }
        });
        // 初始状态为UNKNOWN，如果经过上面的检查仍然为UNKNOWN，则没有问题，返回UP
        if (builder.build().getStatus().equals(Status.UNKNOWN)) {
            builder.up();
        }
    }
}
