package com.weather.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cities")
    public String listCity() throws Exception {
        String body = restTemplate.
                getForEntity("http://weather-eureka-client-ribbon/cities",String.class)
                .getBody();
        return body;
    }
}
