package com.example.demo.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {

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
		return hello + "--8762";
	}
	
}
