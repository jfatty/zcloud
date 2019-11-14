package com.jfatty.zcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.jfatty.zcloud")
public class ZcloudSystemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudSystemServiceApplication.class, args);
    }

}
