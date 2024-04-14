package com.linkedbear.springboot.webmvc.m_resttemplate;

import com.linkedbear.springboot.webmvc.c_requestparam.Department;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

public class RestInterfaceApplication {
    
    public static void main(String[] args) {
        RestClient restClient = RestClient.create();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        RestInterface restInterface = factory.createClient(RestInterface.class);
        List<Department> departmentList = restInterface.findAll();
        System.out.println(departmentList);
        System.out.println(restInterface.get("c8854796f65e4ce791cb2cbaeeb1efc3"));
    }
}
