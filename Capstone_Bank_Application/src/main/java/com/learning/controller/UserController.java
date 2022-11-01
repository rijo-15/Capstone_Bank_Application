package com.learning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.User;
import com.learning.repo.UserRepo;

@RequestMapping("/api/customer")
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	//POST
	  @PostMapping("/api/customer/register")
	  User newUser(@RequestBody User user){
	  
	  return userRepo.save(user); 
	  }
/*
 * POST - TSION (/api/customer/:customerID/
acocunt)

 */
	//role Staff
	//@PostMapping("/")
	@GetMapping("/home")
	String display() {
		return "Welcome";
	}
	
	
}
