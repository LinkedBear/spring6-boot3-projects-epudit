package com.linkedbear.springboot.webmvc.m_resttemplate;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;

public class RestClientApplication {
    
    public static void main(String[] args) {
        RestClient restClient = RestClient.create();
        /*
        String response = restClient.get().uri("http://localhost:8080/department/findAll")
                .accept(MediaType.APPLICATION_XML)
                .retrieve().body(String.class);
        System.out.println(response);
         */
        
        /*
        Department department = new Department("123456789", "RestTemplate部门", "9999987");
        String response = restClient.post().uri("http://localhost:8080/department/saveJson").body(department).retrieve()
                .body(String.class);
        System.out.println(response);
        */
        
        Department department = new Department("123456789", "RestTemplate部门", "9999987");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        BeanMap beanMap = BeanMap.create(department);
        for (Object key : beanMap.keySet()) {
            params.add(key.toString(), beanMap.get(key).toString());
        }
        String response = restClient.post().uri("http://localhost:8080/department/").body(params)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).retrieve().body(String.class);
        System.out.println(response);
    }
}
