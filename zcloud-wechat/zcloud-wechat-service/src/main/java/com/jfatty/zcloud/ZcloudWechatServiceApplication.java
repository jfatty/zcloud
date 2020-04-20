package com.jfatty.zcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.jfatty.zcloud")
public class ZcloudWechatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudWechatServiceApplication.class, args);
        log.error("ZcloudWechatServiceApplication 启动成功!");
    }

}
