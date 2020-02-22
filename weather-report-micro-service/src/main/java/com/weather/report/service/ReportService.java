package com.weather.report.service;



import com.weather.report.client.DataClient;
import com.weather.report.vo.Weather;
import com.weather.report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReportService {

    @Autowired
    private DataClient dataClient;

    public Weather getDataByCityId(String id) {

        // 由天气数据API微服务来提供数据
        WeatherResponse response = dataClient.getDataByCityId(id);
        return response.getData();
    }
}
