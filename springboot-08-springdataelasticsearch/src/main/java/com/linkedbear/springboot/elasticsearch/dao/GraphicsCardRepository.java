package com.linkedbear.springboot.elasticsearch.dao;

import com.linkedbear.springboot.elasticsearch.entity.GraphicsCard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicsCardRepository extends ElasticsearchRepository<GraphicsCard, Integer> {
    
    List<GraphicsCard> findAllByNameLike(String name);
    
    List<GraphicsCard> findAllByPriceGreaterThan(Integer price);
}
