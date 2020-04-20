package com.jfatty.zcloud;

import com.jfatty.zcloud.health.datasource.DynamicDataSourceRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
@ComponentScan(value = {"com.jfatty.zcloud" })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.jfatty.zcloud.system.feign","com.jfatty.zcloud.hospital.feign","com.jfatty.zcloud.wechat.feign"})
public class ZcloudHealthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudHealthServiceApplication.class, args);
        log.error("ZcloudHealthServiceApplication 启动成功!");
    }

}
