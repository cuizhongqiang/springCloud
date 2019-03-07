package com.example.demo.eureka.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@EnableConfigServer
@SpringBootApplication
public class DemoEurekaConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConfigServerApplication.class, args);
    }

}
