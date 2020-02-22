package com.weather.collection.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class CollectionService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
    private final Long TIME_OUT = 1800L;

    public void syncDataByCityId(String id){
        log.info("Start 同步天气.cityId:"+id);
        String uri = WEATHER_API + "?citykey=" + id;
        saveDate(uri);
        log.info("End 同步天气");
    }

    private void saveDate(String uri) {
        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String body = null;
        ResponseEntity<String> resp = restTemplate.getForEntity(uri,String.class);
        if (resp.getStatusCodeValue() == 200) {
            body = resp.getBody();
        }
        ops.set(key,body,TIME_OUT, TimeUnit.SECONDS);
    }
}
