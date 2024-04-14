package com.linkedbear.springboot.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("land")
@Component
public class Rabbit {
    
}
