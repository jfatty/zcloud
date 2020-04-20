package com.jfatty.zcloud.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.jfatty.zcloud")
public class ZcloudAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudAuthServiceApplication.class, args);
        log.error("ZcloudAuthServiceApplication 启动成功!");
    }

}
