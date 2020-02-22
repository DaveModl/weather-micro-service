package com.weather.data.controller;

import com.weather.data.service.DataService;
import com.weather.data.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private DataService dataService;

    @GetMapping("/cityid/{id}")
    public WeatherResponse getDataByCityId(@PathVariable("id") String id){
        return dataService.getDataByCityId(id);
    }

    @GetMapping("/cityname/{name}")
    public WeatherResponse getDataByCityName(@PathVariable("name") String name){
        return dataService.getDataByCityName(name);
    }
}
