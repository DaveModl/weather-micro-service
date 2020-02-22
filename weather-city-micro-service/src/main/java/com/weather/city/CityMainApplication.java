package com.weather.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CityMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityMainApplication.class,args);
    }
}
