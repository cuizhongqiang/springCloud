package com.example.demo.eureka.feign.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
/*
 * 需要特别注意的是我们之前的Feign服务由于内置断路器支持， 所以没有@EnableCircuitBreaker注解，但要使用Dashboard则必须加，如果不加，
 * Dashboard无法接收到来自Feign内部断路器的监控数据，会报“Unable to connect to Command Metric Stream”错误
 */
@EnableCircuitBreaker
@EnableHystrixDashboard
public class DemoEurekaFeignServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaFeignServerApplication.class, args);
    }

}
