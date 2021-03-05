package com.micro.lcl.gataway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/417:25
 */

@Configuration
public class GatawayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/baidu")
                        .uri("http://www.baidu.com"))
                .build();
    }
}