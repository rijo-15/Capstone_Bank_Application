package com.learning.repo;

import com.learning.entity.Beneficiary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long>{
	
	@Query(value = "select * from beneficiary where approved !='yes' " , nativeQuery = true)
	 public List<Beneficiary>beneficiaryNotApproved();
	
	@Query(value ="SELECT b from Beneficiary b WHERE customer_id=:customerId")
	List<Beneficiary>findAllBeneficiarybyId(@Param("customerId") long customerId);
  
	@Modifying
    @Query(value="delete from beneficiary where bid= :id", nativeQuery=true)
    void deleteBeneficiary(@Param("id") long id);


}
