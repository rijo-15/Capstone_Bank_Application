package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.repo.AccountRepo;

@RequestMapping("/api/staff")
@RestController
public class AccountController {

	@Autowired
	AccountRepo accountRepo;
	
	@PostMapping("/addaccount")
	Account newAccount(@RequestBody Account account){
	  return accountRepo.save(account); 
	  }
	
	@GetMapping("/getaccount")
	List<Account> getUser(){
		return accountRepo.findAll();
	}
	 //Second Method
	  @PostMapping("/{id}/account")
	    Account addAccount(@PathVariable("id") long id, @RequestBody Account account) {
	   	 account.setCustomerId(id);
	   	 return accountRepo.save(account);
	    }
	  
	 
	 //Seventh Method - GET 
	  
	  
	  
	  
	  
}
