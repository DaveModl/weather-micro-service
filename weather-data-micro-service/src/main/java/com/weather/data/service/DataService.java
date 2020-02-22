package com.weather.data.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.data.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class DataService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    public WeatherResponse getDataByCityId(String id){
        String uri = WEATHER_API + "?citykey=" + id;
        return getWeatherData(uri);
    }

    public WeatherResponse getDataByCityName(String name){
        String uri = WEATHER_API + "?city=" + name;
        return getWeatherData(uri);
    }



    private WeatherResponse getWeatherData(String uri){
        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String body = null;
        //cache
        if (!this.stringRedisTemplate.hasKey(key)){
            log.info("not find key " + key);
            throw new RuntimeException("没有相应的天气信息");
        }else {
            log.info("find key " + key + ", value=" + ops.get(key));
            body = ops.get(key);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = mapper.readValue(body,WeatherResponse.class);
        } catch (JsonProcessingException e) {
            log.error("JSON反序列化异常",e);
            throw new RuntimeException("JSON反序列化异常,天气解析失败");
        }
        return weatherResponse;
    }
}
