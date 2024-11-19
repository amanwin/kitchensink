package com.mongodb.kitchensink.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ResourcesConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
