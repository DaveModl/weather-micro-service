package com.weather.report.controller;

import com.weather.report.client.DataClient;
import com.weather.report.service.ReportService;
import com.weather.report.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private DataClient dataClient;

    @Autowired
    private ReportService reportService;

    @GetMapping("/cityid/{id}")
    public ModelAndView getReportByCityId(@PathVariable("id") String id, Model model) throws Exception {
        // 由城市数据API微服务来提供数据
        List<City> cityList = null;
        try {
            // 调用城市数据API
            cityList = dataClient.listCity();
        } catch (Exception e) {
            log.error("获取城市信息异常！", e);
            throw new RuntimeException("获取城市信息异常！", e);
        }

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", id);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", reportService.getDataByCityId(id));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
