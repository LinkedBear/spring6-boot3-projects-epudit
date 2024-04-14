package com.linkedbear.springboot.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Accessors(chain = true)
@Document(indexName = "gpu")
public class GraphicsCard {
    
    @Id
    private Integer id;
    
    private String name;
    
    private String brand;
    
    private Integer price;
}