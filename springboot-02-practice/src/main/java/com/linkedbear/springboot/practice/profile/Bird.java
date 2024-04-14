package com.linkedbear.springboot.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"land", "sky"})
@Component
public class Bird {
    
}
