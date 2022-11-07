package com.learning.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.learning.entity.User;
import com.learning.repo.UserRepo;

@Component("userSecurity")
public class UserSecurity {
	
	 @Autowired	
	 UserRepo userRepo;
	
     public boolean hasUserId(Authentication authentication, Long userId) {
        
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String currentUserName = "";
    	
    	if (principal instanceof UserDetails) {
  		  currentUserName = ((UserDetails)principal).getUsername();
  		  
  		  User inputUser = userRepo.findById(userId)
				  .orElseThrow(() -> new RuntimeException("Sorry customer with ID: " + userId + " not found."));
  		  String InputUserName = inputUser.getUserName();
		  
  		  if(currentUserName.equals(InputUserName)) {
  			  return true;
  		  }
  		  
  		  
  		} else {
  		  return false;
  		}
    	return false;
    }
}
