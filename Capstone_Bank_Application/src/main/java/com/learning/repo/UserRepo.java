package com.learning.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);

}

