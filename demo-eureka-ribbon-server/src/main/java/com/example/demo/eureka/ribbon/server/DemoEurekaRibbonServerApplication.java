package com.example.demo.eureka.ribbon.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
public class DemoEurekaRibbonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaRibbonServerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceFailure")
    @GetMapping("/")
    public String home() {
        return restTemplate.getForObject("http://service-client/", String.class);
    }

    @HystrixCommand(fallbackMethod = "serviceFailure")
    @RequestMapping("/hello")
    public String hello() {
        return "hello 8887";
    }

    public String serviceFailure() {
        return "hello world service is not available !";
    }

}
