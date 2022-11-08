package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.User;
import com.learning.repo.StaffRepo;

@RequestMapping("/api/staff")
@RestController
public class StaffController {
	
	@Autowired
	StaffRepo staffRepo;
	
	@GetMapping("/customer")
	List<User> getAllCustomers()
	{
		return staffRepo.getCustomers("user");
	}
	
	@GetMapping("/customer/{id}")
	User getCustomerById(@PathVariable("id") long id) {
		return staffRepo.getCustomerById(id);
	}
	
}