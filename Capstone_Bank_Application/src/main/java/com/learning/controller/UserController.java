package com.learning.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
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
	  
	 //
	 @Autowired 
	 AccountRepo accountRepo;
	 
	@PostMapping("/{id}/account")
	Account addAccount(@PathVariable("id") long id, @RequestBody Account account) {
		if(userRepo.findById(id).isPresent()) //checks if customer exists
		{
	     account.setCustomerId(id);
	     return accountRepo.save(account);
		}
	    return null;
	}

	 
	@GetMapping("/{customer_id}/account")
	   List<Account> findAccountsByCustomerId(@PathVariable("customer_id") long customer_id){
	       return accountRepo.findAccountsByCustomerId(customer_id);
    }


	@PutMapping("/{customerId}/account/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable("customerId") long customerId,
                                                   @PathVariable("accountNo") long accountNo) {
        User originalCustomer = userRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer does not exist customerId:" + customerId));
        Account originalAccount = accountRepo.findById(accountNo)
                .orElseThrow(() -> new RuntimeException("Account does not exist accountNo:" + accountNo));
        
        if(originalAccount.getCustomerId() == customerId)
        {
            originalAccount.setApproved(true);
        }
        else{
           throw new RuntimeException("Account: " + accountNo + "does not belong to customerID: " + customerId);
        }
        
        accountRepo.save(originalAccount);
        return ResponseEntity.ok(originalAccount);
    }

	@GetMapping("/{customerId}/account/{accountNo}")
	Account getCustomerAndAccountById(@PathVariable("customerId") long customerId,
            @PathVariable("accountNo") long accountNo){
		
		return accountRepo.findAccountsByCustomerIdAndAccountNo(accountNo, customerId); //accountNo
	}
	
	
	//psuedo code for add beneficiary
	/*
	@PostMapping("/{id}/beneficiary")
	Beneficiary addBeneficiary(@PathVariable("id") long id, @RequestBody Beneficiary beneficiary) {
				
		if(userRepo.findById(id).isPresent()) //checks if customer exists
		{
			User enteredUser = userRepo.findById(id)
					.orElseThrow(() -> new RuntimeException("Customer does not exist customerId:" + id));
	        
		    // check if customer has the entered account
			long accountNo = beneficiary.getAccountNumber();
			if(accountRepo.findById(accountNo).isPresent()) {
			
				//check if account belongs to customer
				Account enteredAccount = accountRepo.findById(id)
						.orElseThrow(() -> new RuntimeException("Account does not exist accountNo:" + accountNo));
		        
				if(enteredAccount.getCustomerId() == id) {
					//adds beneficiary to beneficiary repo
					beneficiaryRepo.save(beneficiary);
				}
				
			}
		}
	    return null;
	}
	*/
	
	
}
