package com.mk.mkspringboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mk.mkspringboot.resources")
public class MkSpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(MkSpringbootApplication.class, args);
	}
}
