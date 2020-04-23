package com.jihu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean("restTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
