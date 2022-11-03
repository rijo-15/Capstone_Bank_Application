package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	
	@Query(value = "SELECT a FROM Account a WHERE a.customerId=:customerId")
    public List<Account> findAccountsByCustomerId(@Param("customerId") long customerId);


	@Query(value = "SELECT a FROM Account a WHERE a.customerId=:customerId")
    public List<Account> findAccountsByCustomerId(@Param("customerId") long customerId);
	
	@Query(value = "SELECT a FROM Account a WHERE a.accountNumber= :accountNumber and a.customerId=:customerId")
	public Account findAccountsByCustomerIdAndAccountNo(@Param("accountNumber") long accountNumber, 
																@Param("customerId") long customerId);
}
