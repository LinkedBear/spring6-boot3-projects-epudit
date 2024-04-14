package com.linkedbear.spring.d_webmvc_anno;

import com.linkedbear.spring.d_webmvc_anno.config.RootConfiguration;
import com.linkedbear.spring.d_webmvc_anno.config.WebMvcConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfiguration.class};
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebMvcConfiguration.class};
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
