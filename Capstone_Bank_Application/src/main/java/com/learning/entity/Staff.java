package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff {
	
	@Id
	@Column(name= "staffId")
	private long id; 
	@Column(name = "username")
	private String username; 
	@Column(name = "password")
	private String password; 
	@Column(columnDefinition = "varchar(255) default 'STAFF'", name = "role")
	private String role;

}
