package com.jfatty.zcloud.hospital;

import com.jfatty.zcloud.hospital.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;



@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
@EnableDiscoveryClient
@ComponentScan("com.jfatty.zcloud")
public class  ZcloudHospitalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudHospitalServiceApplication.class, args);
    }

}
