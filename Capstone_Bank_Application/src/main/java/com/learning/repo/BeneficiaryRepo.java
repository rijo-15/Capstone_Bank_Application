package com.learning.repo;

import com.learning.entity.Beneficiary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long>{
	
	@Query(value = "Select * from Beneficiary where approved != 'yes'", nativeQuery = true)
	 public List<Beneficiary> beneficiaryNotApproved(); 
	

}
