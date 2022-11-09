package com.learning.controller;

import java.util.List;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learning.entity.Beneficiary;
import com.learning.entity.Payload;
import com.learning.entity.User;
import com.learning.repo.BeneficiaryRepo;

import com.learning.entity.Account;


import com.learning.repo.AccountRepo;

import com.learning.repo.StaffRepo;
import com.learning.repo.UserRepo;

@CrossOrigin 
@RequestMapping("/api/staff")
@RestController
public class StaffController {
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	BeneficiaryRepo beneficiaryRepo;

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	@PutMapping("/accounts/approve")
	public ResponseEntity<Account> updateAccountApproval(@RequestBody Account account){
	            
	      long accNo = account.getAccountNumber();
	          
	      Account updateAccount = accountRepo.findById(accNo)
	              	.orElseThrow(() -> new RuntimeException("Sorry account with accNo: " + accNo + " not found."));
	          
	                updateAccount.setApproved(account.getApproved());

	      accountRepo.save(updateAccount);
	      return ResponseEntity.ok(updateAccount);
	}

	
	@GetMapping("/customer")
	List<User> getAllCustomers()
	{
		return staffRepo.getCustomers("user");
	}
	
	@PutMapping("/customer")
	public ResponseEntity<User> updateCustomerStatus(@RequestBody User user){
			
		  long id = user.getUserId();
		  
		  User updateUser = userRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Sorry customer with ID: " + id + " not found."));
		  
		  		  updateUser.setStatus(user.getStatus());

		  userRepo.save(updateUser);
		  return ResponseEntity.ok(updateUser); 
	  }
	  
	
	
	@GetMapping("/customer/{id}")
	User getCustomerById(@PathVariable("id") long id) {
		return staffRepo.getCustomerById(id);
	}
	



	
	
	
	//Third Method 
	//PUT("/api/staff/beneficiary)
	
	@PutMapping("/beneficiary")
	public ResponseEntity<Beneficiary> approveBeneficiary(@PathVariable("id") long id, @RequestBody Beneficiary beneficiary){
		Beneficiary updateBeneficiary = beneficiaryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("not found")); 
		
		updateBeneficiary.setApproved(beneficiary.getApproved()); 
		
		beneficiaryRepo.save(updateBeneficiary);
		return ResponseEntity.ok(updateBeneficiary); 
		
		
	}
	
	//Fouth Method 
	//Get("/api/staff/accounts/approve")
	@GetMapping("/accounts/approve")
	  List<Beneficiary> beneficiarytoApprove(){
		
	   	 return beneficiaryRepo.beneficiaryNotApproved();
	   	 
	    }
	
	@PutMapping("/transfer")
	public Payload transfer(@RequestBody Payload payload) {
   	 long fromAccNumber = payload.getFromAccNumber();
   	 long toAccNumber = payload.getToAccNumber();
   	 
   	 //System.out.println("fromAccNumber: " + fromAccNumber);
   	 
   	 //checks if both accounts exist
   	 if(accountRepo.findById(fromAccNumber).isPresent()
   			 && accountRepo.findById(toAccNumber).isPresent())
   	 {
   		  Account fromAcc = accountRepo.findById(fromAccNumber)
  				   .orElseThrow(() -> new RuntimeException("Sorry from account with ID: " + fromAccNumber + " not found."));
   		 
   		  Account toAcc = accountRepo.findById(toAccNumber)
 					   .orElseThrow(() -> new RuntimeException("Sorry to account with ID: " + toAccNumber + " not found."));
   		 
   		 
   		  long staffId = payload.getByStaffId();
   		 
   		  //checks if account belongs to customer
   		  double amountTransfer = payload.getAmount();
   			 
   		  fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amountTransfer);
   		  toAcc.setAccountBalance(toAcc.getAccountBalance() + amountTransfer);

   		  accountRepo.save(fromAcc);
   		  accountRepo.save(toAcc);
   			 
   	      return payload;
   	 }
   	 
   	 return null;
	}
	

}



