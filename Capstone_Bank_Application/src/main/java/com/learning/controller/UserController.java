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

import com.learning.entity.Account;
import com.learning.entity.User;
import com.learning.repo.AccountRepo;
import com.learning.repo.UserRepo;
import com.learning.service.UserService;

@RequestMapping("/api/customer")
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	UserService userService;
	
	//get customer by specifying id (staff role)
	
	//Fifth Method -Get 
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
	
	// First method Register user (customer role)
	  @PostMapping("/register")
	  User newUser(@RequestBody User user){
	  return userRepo.save(user); 
	  }
	  
	  
	  //Third Method PUT 
	  
	  
	  //Fourth Method Get 
	  @GetMapping("/{customer_id}/account")
	    List<Account> findAccountsByCustomerId(@PathVariable("customer_id") long customer_id){
	   	 return accountRepo.findAccountsByCustomerId(customer_id);
	   	 
	    }
	  
	  //Sixth Method - PUT
	  
	  
	  
	  //Eight Method - POST 
	  
	  
	  //Nine Method -  
	  
	  
	  
	  
	  
	  
	  
	  
	   
	  

	  
	  
	 



	  
	  

}
