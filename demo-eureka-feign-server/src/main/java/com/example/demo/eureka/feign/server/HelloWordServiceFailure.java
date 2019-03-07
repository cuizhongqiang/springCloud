package com.example.demo.eureka.feign.server;

import org.springframework.stereotype.Component;

@Component
public class HelloWordServiceFailure implements HelloWordService {

    @Override
    public String sayHello() {
        return "sayHello fail ********* !";
    }

    @Override
    public String hello() {
        return "hello fail ********** !";
    }

}
