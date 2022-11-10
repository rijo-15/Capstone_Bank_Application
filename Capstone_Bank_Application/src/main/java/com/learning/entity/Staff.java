package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private long id; 
	@Column(name = "username")
	private String username; 
	@Column(name = "password")
	private String password; 
	@Column(name = "fname")
	private String fname; 
	@Column(name = "lname")
	private String lname; 
	@Column(columnDefinition = "varchar(255) default 'STAFF'", name = "role")
	private String role;
	@Column(columnDefinition = "varchar(255) default 'Enabled'", name = "status")
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(long id, String username, String password, String role, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", status="
				+ status + "]";
	}
	
	
}
