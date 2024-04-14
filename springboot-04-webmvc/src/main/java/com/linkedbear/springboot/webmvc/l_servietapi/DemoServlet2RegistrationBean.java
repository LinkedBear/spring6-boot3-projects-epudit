package com.linkedbear.springboot.webmvc.l_servietapi;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

public class DemoServlet2RegistrationBean extends ServletRegistrationBean<DemoServlet2> {
    
    public DemoServlet2RegistrationBean(DemoServlet2 servlet, String... urlMappings) {
        super(servlet, urlMappings);
    }
}
