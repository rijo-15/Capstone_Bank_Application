package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.learning.repo")
public class CapstoneBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneBankApplication.class, args);
		System.out.println("test");
	}

}
