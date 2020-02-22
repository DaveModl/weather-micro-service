package com.weather.report.service;

import com.weather.report.client.DataClient;
import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("101010100");
        city.setCityName("北京");
        cityList.add(city);

        city = new City();
        city.setCityId("101010200");
        city.setCityName("海淀");
        cityList.add(city);
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String id) {
        return new WeatherResponse();
    }
}
