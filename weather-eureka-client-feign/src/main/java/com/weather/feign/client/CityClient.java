package com.weather.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("weather-city-micro-service")
public interface CityClient {
    @GetMapping("/cities")
    String listCity();
}
