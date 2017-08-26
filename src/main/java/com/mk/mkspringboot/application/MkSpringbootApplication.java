package com.mk.mkspringboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.mk.mkspringboot")
@EnableJpaRepositories("com.mk.mkspringboot.domain.repository")
@EntityScan("com.mk.mkspringboot.domain.models")
public class MkSpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(MkSpringbootApplication.class, args);
	}
}
