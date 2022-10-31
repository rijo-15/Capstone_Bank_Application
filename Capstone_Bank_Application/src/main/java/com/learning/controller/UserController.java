package com.learning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.learning.repo.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;

}
