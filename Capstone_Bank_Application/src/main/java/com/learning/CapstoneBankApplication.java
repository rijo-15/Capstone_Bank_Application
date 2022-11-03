package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
public class CapstoneBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneBankApplication.class, args);
		System.out.println("test");
	}

}
