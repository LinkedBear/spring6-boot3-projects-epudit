package com.linkedbear.spring.feature.observerd.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import org.springframework.stereotype.Component;

@Component
public class DemoObservedHandler implements ObservationHandler<Observation.Context> {
    
    @Override
    public void onStart(Observation.Context context) {
        System.out.println("==== on start ====");
        System.out.println(context.getName());
        System.out.println(context.getContextualName());
    }
    
    @Override
    public void onStop(Observation.Context context) {
        System.out.println("==== on stop ====");
    
    }
    
    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}
