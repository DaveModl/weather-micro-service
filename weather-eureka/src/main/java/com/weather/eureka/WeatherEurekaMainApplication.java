package com.weather.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class WeatherEurekaMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherEurekaMainApplication.class,args);
    }
}
