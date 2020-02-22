package com.weather.feign.client;

import com.weather.feign.vo.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DataClient {
    @GetMapping("/weather/cityId/{id}")
    WeatherResponse getDataByCityId(@PathVariable("id") String id);
}
