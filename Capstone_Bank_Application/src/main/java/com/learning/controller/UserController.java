package com.learning.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import com.learning.repo.BeneficiaryRepo;
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
	
	@Autowired
	BeneficiaryRepo beneficiaryRepo;
	
	
	//for testing purposes
	@RequestMapping("/home")
	public String home() {
		return ("<h1>Welcome Home</h1>");
	}
		// First method Register user (customer role)
		  @PostMapping("/register")
		  User newUser(@RequestBody User user){
		  return userRepo.save(user); 
		  }

		//role staff (to get multiple user info)
			@GetMapping("/getcustomers")
			List<User> getUser(){
				return userRepo.findAll();
			}

			/*
		  //Second Method
			/*
			 * Function to create an account for user (Authority USER)
			 * */
		  @PostMapping("/{id}/account")
		    String addAccount(@PathVariable("id") long id, @RequestBody Account account) {
		   	 if(userRepo.findById(id).isPresent()) //checks if customer exists
		   	 {
		     	account.setCustomerId(id);
		     	accountRepo.save(account);
		     	return "Account added successfully"; 
		   	 }
		    	return "Account added unsuccessfull";
		    }

		  /*
		   * Approves Account created by user (Authority Staff)
		   * */
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
		        	originalAccount.setApproved("Yes");
		    	}
		    	else{
		       	throw new RuntimeException("Account: " + accountNo + "does not belong to customerID: " + customerId);
		    	}
		   	 
		    	accountRepo.save(originalAccount);
		    	return ResponseEntity.ok(originalAccount);
			}
		  /*
		   * Function to get all accounts which are opened by customer
		   * Authority(STAFF)
		   */
		   	  
		  //Fourth Method Get 
		  @GetMapping("/{customer_id}/account")
		    List<Account> findAccountsByCustomerId(@PathVariable("customer_id") long customer_id){
		   	 return accountRepo.findAccountsByCustomerId(customer_id);
		   	 
		    }	  
	/*
	 * Function to get customer by specified Id
	 * Fifth Method -Get 
	 */
	@GetMapping("/getcustomer/{userId}") 
	Optional<User> getUserById(@PathVariable long userId){
		try {
			return userRepo.findById(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRepo.findById(userId);
	}

	
		  /*
	  //Sixth Method - PUT
	  @PutMapping("/{customerID}")
	
	/*
	 * Update the user in the payload if the userName match and exists
	 * Sixth Method - PUT
	 */
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
	  
	  
	  
//	  @PutMapping("cus/{customerID}") //Id
//	  ResponseEntity<User> updateCustomer(@PathVariable ("userId")long customerId,@RequestBody User user) 
//	  {
//	  		User updateUser = userRepo.findById(customerId)
//	  		.orElseThrow(() -> new RuntimeException("User not exist with user_id: " + customerId));
//	  		updateUser.setEmail(user.getEmail()); //update email
//	  		updateUser.setPhone(user.getPhone()); //phone number
//	  		updateUser.setLastName(user.getLastName()); //last name
//	  			
//	  		userRepo.save(updateUser);
//	  		System.out.println("update customer");
//	  		
//	  		return ResponseEntity.ok(updateUser);
//	  		
//	  		}
	   
	  
		  /*
		   * Get customer Account with specified Account #
		   * Authority I think Staff
		   * SEVENTH MEthod
		   */
	  @GetMapping("/{customerId}/account/{accountNo}")
	    Account getCustomerAndAccountById(@PathVariable("customerId") long customerId,
	        	@PathVariable("accountNo") long accountNo){
	   	 
	   	 return accountRepo.findAccountsByCustomerIdAndAccountNo(accountNo, customerId); //accountNo
	    }

	/*
	 * Should add the beneficiary for the customer with valid account number
	 * Eight Method POST 
	 */
	  @PostMapping("{customerID}/beneficiary")
	  Beneficiary addBeneficiary(@PathVariable("customerID") long customerID, @RequestBody Beneficiary beneficiary ) {
		  
		  try {
			  User user = userRepo.findById(customerID).get();
			  beneficiary.addBenficaryToUser(user);
		  }catch(Exception e) {
				e.printStackTrace();
			}
		  
		  return beneficiaryRepo.save(beneficiary);
	  }
	  
	  
	  //Nine Method -  GET(/:customerID/beneficiary) 
//	  @GetMapping("/{customerID}/beneficiary")	  
//	    List<Beneficiary> findAccountsByBeneficiaryId(@PathVariable("beneficiary_id") long beneficiary_id){
//	   	 return accountRepo.findAccountsByCustomerId(customer_id);
//	   	 
//	    }
	  
	  
	  
	  //Tenth Method - Delete(/:customerID/beneficiary/:beneficiaryID) 
//	  @DeleteMapping("{customerID}/beneficiary/{beneficiaryID}")	  
//	  String deleteBeneficiaryById(@PathVariable("id") int id) {
//		  try {
//			  benefi.deleteById(id);
//			  return "Beneficiary Deleted Successfully"; 
//		  }catch(Exception e) {
//			  e.printStackTrace();
//			  return "Beneficiary Not Delete"; 
//		  }
//	  }
	  
	  
	  //Eleventh Method 
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
		

	  
	  
	  
	  
	  
	//checks if current user is calling url of current user or other user
	    boolean checksCurrentUserUrlCall(long id) {
	   	 
	   	 //Used to find current logged in customer
	   	 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	   	 String currentUserName = "error";
	   	 if (principal instanceof UserDetails) {
	   	   currentUserName = ((UserDetails)principal).getUsername();
	   	   
	   	 } else {
	   	   //currentUserName = principal.toString();
	   	   return false;
	   	 }
	   	 
	   	 User inputUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer does not exist customerId:" + id));
	   	 String inputUserName = inputUser.getUserName();
	   	 if(!inputUserName.equals(currentUserName))
	   	 {
	   		 System.out.println("currentUser: " + currentUserName + " <h1>you do not have access to this user</h1> " + inputUserName);
	   		 return false;

	   	 }
	   	 //("<h1>hello user</h1> " + currentUserName + "with userId " + id + " you have access");
	   	 return true;
	    }


	  
	  
	
	


		
	
}
