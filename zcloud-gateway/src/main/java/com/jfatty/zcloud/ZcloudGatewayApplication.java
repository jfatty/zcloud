package com.jfatty.zcloud;

import com.jfatty.zcloud.gateway.RequestBodyRoutePredicateFactory;
import com.jfatty.zcloud.gateway.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ZcloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudGatewayApplication.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public RequestBodyRoutePredicateFactory requestBodyRoutePredicateFactory() {
        return new RequestBodyRoutePredicateFactory();
    }

}
