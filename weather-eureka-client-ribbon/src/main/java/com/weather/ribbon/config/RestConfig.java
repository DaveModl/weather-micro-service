package com.weather.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "ribbon-client",configuration = RibbonConfig.class )
public class RestConfig {
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return builder.build();
    }
}
