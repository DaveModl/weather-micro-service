package com.weather.eureka.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class,args);
    }

//    @Bean
//    public RouteLocator customerRoute(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("path_route_city",r -> r.path("/city/**")
//                        .uri("http://localhost:8085")
//                        .uri("http://localhost:8086"))
//                .route("path_route_data",r -> r.path("/data/**")
//                        .uri("http://localhost:8083")
//                        .uri("http://localhost:8084"))
//                .build();
//    }
}
