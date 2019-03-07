package com.example.demo.eureka.feign.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "service-client", fallback = HelloWordServiceFailure.class)
public interface HelloWordService {

    @GetMapping("/")
    String sayHello();

    @GetMapping("/hello")
    String hello();

}
