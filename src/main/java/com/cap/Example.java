package com.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration // equivalent to start Spring Boot and this class is a starting configuration class: @ScanComponent and @EnableAnnotation
@SpringBootApplication // equivalent to @Configuration, @EnableAutoConfiguration and @Component
public class Example {
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Example.class, args);
	}

}
