package com.jfatty.zcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jfatty.zcloud")
public class ZcloudAlipayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcloudAlipayServiceApplication.class, args);
    }

}
