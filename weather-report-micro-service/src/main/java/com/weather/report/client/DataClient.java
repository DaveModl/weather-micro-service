package com.weather.report.client;

import com.weather.report.service.DataClientFallback;
import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "weather-eureka-client-gateway",fallback = DataClientFallback.class)
public interface DataClient {

        @GetMapping("/city/cities")
        List<City> listCity() throws Exception;


        @GetMapping("/data/weather/cityid/{id}")
        WeatherResponse getDataByCityId(@PathVariable("id") String id);
}