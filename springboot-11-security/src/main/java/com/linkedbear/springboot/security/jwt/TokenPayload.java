package com.linkedbear.springboot.security.jwt;

import com.linkedbear.springboot.security.entity.SecurityUser;
import lombok.Data;

import java.util.Date;

@Data
public class TokenPayload {
    private String id;
    private SecurityUser user;
    private Date expiration;
}
