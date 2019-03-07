package com.example.demo.eureka.clientb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class DemoEurekaClientbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClientbApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Value("${Hello}")
    String hello;

    @RequestMapping("/")
    public String home() {
        return "hello world from port: " + port;
    }

    @RequestMapping("/hello")
    public String hello() {
        return hello + "--8763";
    }

}
