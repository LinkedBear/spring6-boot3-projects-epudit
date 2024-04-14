package com.linkedbear.springboot.webmvc.m_resttemplate;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class RestDemoApplication {
    
    public static void main(String[] args) {
        /*
        // 简单使用
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/department/findAll", String.class);
        System.out.println(response);
        */
        
        /*
        // 指定使用json格式返回
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/department/findAll",
                HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());
        */
        
        /*
        // 使用模型类接收
        String id = "2eeb512cfd694de6bc18b4be08c77719";
        RestTemplate restTemplate = new RestTemplate();
        Department response = restTemplate.getForObject("http://localhost:8080/department/" + id, Department.class);
        System.out.println(response);
         */
        
        /*
        // 获取一组数据并用模型类接收
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Department>> responseEntity = restTemplate.exchange("http://localhost:8080/department/findAll",
                HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
        System.out.println(responseEntity.getBody());
        */

        /*
        // 发送POST请求
        RestTemplate restTemplate = new RestTemplate();
        Department department = new Department("123456789", "RestTemplate部门", "9999987");
        String response = restTemplate.postForObject("http://localhost:8080/department/saveJson", department, String.class);
        System.out.println(response);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Department>> responseEntity = restTemplate.exchange("http://localhost:8080/department/findAll",
                HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
        System.out.println(responseEntity.getBody());
         */
        
        /*
        // 发送POST请求携带表单数据
        RestTemplate restTemplate = new RestTemplate();
        Department department = new Department("123456789", "RestTemplate部门", "9999987");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        BeanMap beanMap = BeanMap.create(department);
        for (Object key : beanMap.keySet()) {
            params.add(key.toString(), beanMap.get(key).toString());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<?> entity = new HttpEntity<>(params, headers);
        String response = restTemplate.postForObject("http://localhost:8080/department/", entity, String.class);
        System.out.println(response);
        
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<>(headers);
        ResponseEntity<List<Department>> responseEntity = restTemplate.exchange("http://localhost:8080/department/findAll",
                HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
        System.out.println(responseEntity.getBody());
         */
        
        // 定制RestTemplate
        RestTemplate restTemplate = new RestTemplateBuilder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Department department = new Department("123456789", "RestTemplate部门", "9999987");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        BeanMap beanMap = BeanMap.create(department);
        for (Object key : beanMap.keySet()) {
            params.add(key.toString(), beanMap.get(key).toString());
        }
        String response = restTemplate.postForObject("http://localhost:8080/department/", params, String.class);
        System.out.println(response);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Department>> responseEntity = restTemplate.exchange("http://localhost:8080/department/findAll",
                HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
        System.out.println(responseEntity.getBody());
    }
}
