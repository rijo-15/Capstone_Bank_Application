package com.learning.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;

import com.learning.entity.Beneficiary;
import com.learning.entity.Payload;
import com.learning.entity.User;
import com.learning.repo.AccountRepo;
import com.learning.repo.PayloadRepo;
import com.learning.repo.UserRepo;
import com.learning.service.UserService;

//@RequestMapping("/api/customer")
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	UserService userService;
	
	// First method Register user (customer role)
		  @PostMapping("/register")
		  User newUser(@RequestBody User user){
		  return userRepo.save(user); 
		  }
		  
		  //Second Method
		  @PostMapping("/{id}/account")
		    Account addAccount(@PathVariable("id") long id, @RequestBody Account account) {
		   	 if(userRepo.findById(id).isPresent()) //checks if customer exists
		   	 {
		     	account.setCustomerId(id);
		     	return accountRepo.save(account);
		   	 }
		    	return null;
		    }

		  
		  
	      //Third Method PUT 
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
		  
		  
		  //Fourth Method Get 
		  @GetMapping("/{customer_id}/account")
		    List<Account> findAccountsByCustomerId(@PathVariable("customer_id") long customer_id){
		   	 return accountRepo.findAccountsByCustomerId(customer_id);
		   	 
		    }

		  
	
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
	
	  //Sixth Method - PUT
	  @PutMapping("/{customer}")
	  public ResponseEntity<User> updateCustomerDetails(@PathVariable("id") long id, @RequestBody User user){
		  User updateUser = userRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Sorry customer with ID: " + id + " not found.")); 
				  
		  
				  updateUser.setFirstName(user.getFirstName());
				  updateUser.setLastName(user.getLastName()); 
				  updateUser.setPhone(user.getPhone()); 
				  updateUser.setSsn(user.getSsn()); 
				  
				  
				  userRepo.save(updateUser);
				  return ResponseEntity.ok(updateUser); 
	  }
	  
	  
	  //Seventh Method GET(/:customerID/account/:accountID)
	  @GetMapping("/{customerId}/account/{accountNo}")
		Account getCustomerAndAccountById(@PathVariable("customerId") long customerId,
	            @PathVariable("accountNo") long accountNo){
			
			return accountRepo.findAccountsByCustomerIdAndAccountNo(accountNo, customerId); //accountNo
	   }
	
	  //Eight Method POST 
	  
	  
	  //Nine Method -  GET(/:customerID/beneficiary) 
//	  @GetMapping("/{customerID}/beneficiary")	  
//	    List<Beneficiary> findAccountsByBeneficiaryId(@PathVariable("beneficiary_id") long beneficiary_id){
//	   	 return accountRepo.findAccountsByCustomerId(customer_id);
//	   	 
//	    }
	  
	  
	  
	  //Tenth Method - Delete(/:customerID/beneficiary/:beneficiaryID) 
//	  @DeleteMapping("/:customerID/beneficiary/:beneficiaryID")	  
//	  String deleteBeneficiaryById(@PathVariable("id") int id) {
//		  try {
//			  benefi.deleteById(id);
//			  return "Beneficiary Deleted Successfully"; 
//		  }catch(Exception e) {
//			  e.printStackTrace();
//			  return "Beneficiary Not Delete"; 
//		  }
//	  }
	  
	  
	//Eleventh Method - Put(/api/customer/transfer)
	@Autowired
	PayloadRepo payloadRepo;
	  
	  
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
    		 
    		 
    		 long customerId = payload.getByCustomerId();
    		 
    		 //checks if account belongs to customer
    		 if(fromAcc.getCustomerId() == customerId &&
    					 toAcc.getCustomerId() == customerId)
    		 {
    			 double amountTransfer = payload.getAmount();
    			 
    			 fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amountTransfer);
    			 toAcc.setAccountBalance(toAcc.getAccountBalance() + amountTransfer);

    			 accountRepo.save(fromAcc);
    			 accountRepo.save(toAcc);
    			 
    			 return payload;
    		 }
  
    	}
    	
    	return null;
    }
	
    
	//role staff (to get multiple user info)
	/*@GetMapping("/getcustomers")
	List<User> getUser(){
		return userRepo.findAll();
	}*/
    
    @GetMapping("/getcustomers")
	List<User> getUser(){
		return userRepo.findAll();
	}
	
	@GetMapping("/admin")
	public String getHelloAdmin() {
		return "hello admin";
	}
	
	@GetMapping("/admin/1")
	public String getShowAdmin1() {
		return "showing admin 1";
	}
	
	@GetMapping("/user")
	public String getHelloUser(){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = "error";
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  
		} else {
		  username = principal.toString();
		}
		
		return ("<h1>hello user</h1>" + username);
	}
	
	@GetMapping("/user/{id}")
	public String getHelloUser1(){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = "error";
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  
		} else {
		  username = principal.toString();
		}
		
		return ("<h1>hello user</h1> " + username + "got user using /user/**");
	}
	
	@GetMapping("/")
	public String getWelcome(){
		return "Welecome";
	}
	
	
	
}
