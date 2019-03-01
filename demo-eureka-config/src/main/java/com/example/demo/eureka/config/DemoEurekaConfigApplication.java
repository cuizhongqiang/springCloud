package com.example.demo.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConfigApplication.class, args);
    }

}
