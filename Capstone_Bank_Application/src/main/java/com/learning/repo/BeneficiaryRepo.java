package com.learning.repo;

import com.learning.entity.Beneficiary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long>{
	
	@Query(value = "select * from beneficiary where approved !='yes' " , nativeQuery = true)
	 public List<Beneficiary>beneficiaryNotApproved();
	
	@Query(value ="SELECT b from Beneficiary b WHERE customer_id=:customerId")
	List<Beneficiary>findAllBeneficiarybyId(@Param("customerId") long customerId);
 

}
