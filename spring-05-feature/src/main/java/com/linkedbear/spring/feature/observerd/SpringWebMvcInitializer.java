package com.linkedbear.spring.feature.observerd;

import com.linkedbear.spring.feature.observerd.config.RootConfiguration;
import com.linkedbear.spring.feature.observerd.config.WebMvcConfiguration;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.ObservationTextPublisher;
import jakarta.servlet.Filter;
import org.springframework.http.server.observation.DefaultServerRequestObservationConvention;
import org.springframework.http.server.observation.ServerRequestObservationConvention;
import org.springframework.web.filter.ServerHttpObservationFilter;
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
    
    @Override
    protected Filter[] getServletFilters() {
        ObservationRegistry registry = ObservationRegistry.create();
        registry.observationConfig().observationHandler(new ObservationTextPublisher());
        ServerHttpObservationFilter filter = new ServerHttpObservationFilter(registry);
        return new Filter[] {filter};
    }
}
