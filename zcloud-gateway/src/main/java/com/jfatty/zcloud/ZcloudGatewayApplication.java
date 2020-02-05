package com.jfatty.zcloud;

import com.jfatty.zcloud.gateway.RequestBodyRoutePredicateFactory;
import com.jfatty.zcloud.gateway.RequestTimeGatewayFilterFactory;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@MapperScan({"com.jfatty.zcloud.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
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
