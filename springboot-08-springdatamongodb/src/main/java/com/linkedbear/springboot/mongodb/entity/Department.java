package com.linkedbear.springboot.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "doc_dept")
public class Department {
    
    @Id
    private String id;
    
    private String name;
    
    private String tel;
}
