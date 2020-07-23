package com.jfatty.zcloud.hospital;

import com.jfatty.zcloud.hospital.datasource.DynamicDataSourceRegister;
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
@ComponentScan({"com.jfatty.zcloud"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.jfatty.zcloud.wechat.feign","com.jfatty.zcloud.health.feign"})
public class  ZcloudHospitalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudHospitalServiceApplication.class, args);
        log.error("ZcloudHospitalServiceApplication 启动成功!");
    }

}
