package com.example.demo.eureka.feign.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private HelloWordService helloWordService;

    @GetMapping(value = "/")
    public String sayHello() {
        return helloWordService.sayHello();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return helloWordService.hello();
    }

}
