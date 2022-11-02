package com.learning.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.User;
import com.learning.repo.UserRepo;
import com.learning.service.UserService;

@RequestMapping("/api/customer")
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	//get customer by specifying id (staff role)
	@GetMapping("/getcustomer/{userId}") 
	Optional<User> getUserById(@PathVariable long userId){
		try {
			return userRepo.findById(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRepo.findById(userId);
	}
	//role staff (to get multiple user info)
	@GetMapping("/getcustomers")
	List<User> getUser(){
		return userRepo.findAll();
	}
	//Register user (customer role)
	  @PostMapping("/register")
	  User newUser(@RequestBody User user){
	  return userRepo.save(user); 
	  }

}
