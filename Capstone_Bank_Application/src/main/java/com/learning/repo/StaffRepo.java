package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Staff;
import com.learning.entity.User;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {


	@Query(value = "SELECT u FROM User u WHERE u.role=:role")
    public List<User> getCustomers(@Param("role") String role);
	
	@Query(value = "SELECT u FROM User u WHERE u.id=:id")
	public User getCustomerById(@Param("id") long id);
	
	/*
	 * @Modifying
	 * @Query(value = "update s FROM staff s WHERE s.id=:id")
	   public User getCustomerById(@Param("id") long id);
	 */
}
