package com.linkedbear.springboot.mongodb.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Accessors(chain = true)
@Document(collection = "doc_user") // 用value或者collection都可以
public class User {
    
    @Id
    private String id;
    
    @Field("username")
    private String name;
    
    private Integer age;
}
