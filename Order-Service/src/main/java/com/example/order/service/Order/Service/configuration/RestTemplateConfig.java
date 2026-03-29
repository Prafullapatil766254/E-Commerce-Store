package com.example.order.service.Order.Service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // We can call services using their names after using this annotation
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
