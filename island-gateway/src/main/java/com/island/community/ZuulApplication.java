package com.island.community;

import com.island.community.filter.AuthorizedRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient //Zuul注册进eureka
@EnableZuulProxy //Zuul代理，默认情况下会代理注册到eureka server中的所有服务
public class ZuulApplication {

    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter(){
        return new AuthorizedRequestFilter();
    }

    public static void main(String[] args) { //Zuul可实现ribbon负载均衡
        SpringApplication.run(ZuulApplication.class, args);
    }
}