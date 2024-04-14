package com.linkedbear.springboot.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ocean")
@Component
public class Fish {
    
}
