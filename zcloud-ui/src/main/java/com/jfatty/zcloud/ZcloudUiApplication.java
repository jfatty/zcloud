package com.jfatty.zcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@SpringBootApplication( exclude = { DataSourceAutoConfiguration.class } )
@ComponentScan(value = {"com.jfatty.zcloud" })
@EnableDiscoveryClient
@EnableFeignClients
public class ZcloudUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudUiApplication.class, args);
    }
}
