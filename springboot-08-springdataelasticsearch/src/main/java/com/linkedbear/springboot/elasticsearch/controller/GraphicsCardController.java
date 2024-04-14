package com.linkedbear.springboot.elasticsearch.controller;

import com.linkedbear.springboot.elasticsearch.dao.GraphicsCardRepository;
import com.linkedbear.springboot.elasticsearch.entity.GraphicsCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GraphicsCardController {
    
    @Autowired
    private GraphicsCardRepository graphicsCardRepository;
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/test1")
    public String test1() {
        GraphicsCard graphicsCard = new GraphicsCard();
        graphicsCard.setId(1).setBrand("MSI").setPrice(13999);
        graphicsCard.setName("微星（MSI）魔龙 GeForce RTX 4090 D");
        graphicsCardRepository.save(graphicsCard);
        return "success";
    }

    @GetMapping("/test2")
    public String test2() {
        GraphicsCard graphicsCard = new GraphicsCard();
        graphicsCard.setId(2).setBrand("七彩虹").setPrice(14999);
        graphicsCard.setName("七彩虹（Colorful）iGame GeForce RTX 4090 火神");
        elasticsearchTemplate.save(graphicsCard);
        return "success";
    }

    @GetMapping("/test3")
    public String test3() {
        GraphicsCard graphicsCard = new GraphicsCard();
        graphicsCard.setId(3).setBrand("华硕").setPrice(2599);
        graphicsCard.setName("华硕（ASUS） ATS-GeForce RTX4060 8G");
        elasticsearchTemplate.save(graphicsCard);
        return "success";
    }
    
    @GetMapping("/test4")
    public Iterable<GraphicsCard> test4() {
        return graphicsCardRepository.findAll();
    }
    
    @GetMapping("/test5")
    public List<GraphicsCard> test5() {
        return graphicsCardRepository.findAllByNameLike("4090");
    }
    
    @GetMapping("/test6")
    public List<GraphicsCard> test6() {
        return graphicsCardRepository.findAllByPriceGreaterThan(10000);
    }
    
    @GetMapping("/test7")
    public List<GraphicsCard> test7() {
        SearchHits<GraphicsCard> results = elasticsearchTemplate.search(Query.findAll(), GraphicsCard.class);
        return results.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
    
    @GetMapping("/test8")
    public List<GraphicsCard> test8() {
        CriteriaQuery query = new CriteriaQuery(Criteria.where("name").contains("4090"));
        SearchHits<GraphicsCard> results = elasticsearchTemplate.search(query, GraphicsCard.class);
        return results.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
    
    @GetMapping("/test9")
    public GraphicsCard test9() {
        CriteriaQuery query = new CriteriaQuery(Criteria.where("id").is("1"));
        return elasticsearchTemplate.searchOne(query, GraphicsCard.class).getContent();
    }
    
}
