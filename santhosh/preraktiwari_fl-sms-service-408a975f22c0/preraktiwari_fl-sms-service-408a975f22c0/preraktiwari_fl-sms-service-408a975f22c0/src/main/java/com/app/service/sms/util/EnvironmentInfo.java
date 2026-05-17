package com.app.service.sms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class EnvironmentInfo {
    @SuppressWarnings("rawtypes")
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        final Environment environment = event.getApplicationContext().getEnvironment();
        log.info("### Kubernetes Config :: Start ###");
        log.info("selected profiles: {}", Arrays.toString(environment.getActiveProfiles()));
        final MutablePropertySources sources = ((AbstractEnvironment) environment).getPropertySources();
        StreamSupport.stream(sources.spliterator(), false)
                     .filter(ps -> ps instanceof EnumerablePropertySource)
                     .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames()).flatMap(Arrays::stream).distinct()
                     .forEach(prop -> {
                        Object value = environment.getProperty(prop, Object.class);
                        log.info("{} - {}", prop, environment.getProperty(prop));
                     });
        log.info("### Kubernetes Config :: End ###");
    }
}
