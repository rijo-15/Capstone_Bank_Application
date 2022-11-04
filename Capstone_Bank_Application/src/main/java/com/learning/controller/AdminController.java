package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learning.entity.User;
import com.learning.repo.AdminRepo;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
	
	@Autowired
	AdminRepo adminRepo;
	
	
	@PostMapping("/staff")
	User newStaffUser(@RequestBody User user){
//		add context
//		if(adminRepo.findById(user.getUserId()).isPresent()) //checks if customer exists
//	   	 {
//	   	 } 
		 user.setRole("Staff");
			return adminRepo.save(user); 
	}
	
	@GetMapping("/getstaff")
	List<User> getStaffUser(){
		// add context
		
		return adminRepo.findAll();
	}
	
	@PutMapping("/{staff}")
	public ResponseEntity<User> updateStaffStatus(@PathVariable("id") long id, @RequestBody User staffUser){
		  User updateStaffUser = adminRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Sorry staff with ID: " + id + " not found.")); 
				  
		  
				  updateStaffUser.setStatus(staffUser.getStatus());
				  
				  
				  adminRepo.save(updateStaffUser);
				  return ResponseEntity.ok(updateStaffUser); 
	  }
	  
	  
}
