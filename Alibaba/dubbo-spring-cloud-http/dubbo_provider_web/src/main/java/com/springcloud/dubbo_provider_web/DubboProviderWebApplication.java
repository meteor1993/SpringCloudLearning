package com.springcloud.dubbo_provider_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DubboProviderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderWebApplication.class, args);
    }

}
