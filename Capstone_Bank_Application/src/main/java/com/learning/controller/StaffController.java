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
	
	@Autowired
	BeneficiaryRepo beneficiaryRepo;

	
	@GetMapping("/customer")
	List<User> getAllCustomers()
	{
		return staffRepo.getCustomers("user");
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
		
		updateBeneficiary.setapproved(beneficiary.getapproved()); 
		
		beneficiaryRepo.save(updateBeneficiary);
		return ResponseEntity.ok(updateBeneficiary); 
		
		
	}
	
	//Fouth Method 
	//Get("/api/staff/accounts/approve")
	@GetMapping("/accounts/approve")
	  List<Beneficiary> beneficiarytoApprove(){
		
	   	 return beneficiaryRepo.beneficiaryNotApproved();
	   	 
	    }
	
	
	

}


}

