package com.linkedbear.springboot.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"land", "ocean"})
@Component
public class Turtle {
    
}
