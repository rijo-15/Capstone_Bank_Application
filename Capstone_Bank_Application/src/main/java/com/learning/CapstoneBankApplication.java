package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.repo.UserRepo;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class CapstoneBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneBankApplication.class, args);
		System.out.print("test");
	}

}
