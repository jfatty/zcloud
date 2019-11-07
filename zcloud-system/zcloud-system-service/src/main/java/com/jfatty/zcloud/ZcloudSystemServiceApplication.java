package com.jfatty.zcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jfatty.zcloud")
public class ZcloudSystemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudSystemServiceApplication.class, args);
    }

}
