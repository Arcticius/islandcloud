package com.island.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscussPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscussPostApplication.class, args);
    }
}
