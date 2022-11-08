package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId") //is a primary key
	private long userId;
	@Column(name="SSN", unique=true, nullable=false)
	private long ssn;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="UserName", unique=true, nullable=false)
	private String username;
	@Column(name="Password", nullable=false)
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Phone")
	private String phone;
	@Column(name="Role", columnDefinition = "varchar(255) default 'USER'")
	private String role;
	@Column(name= "active")
	private boolean active;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore //to avoid recursive error
	Set<Beneficiary> beneficiary = new HashSet<>();
	
	
	//Account relationship map
	@OneToMany(mappedBy="userAcc")//one user can have many accounts
	@JsonIgnore
	Set<Account> account = new HashSet<>();
	
	
	//Setter and getter methods
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public User() {
		super();
		
	}
	
	public User(long userId, long ssn, String firstName, String lastName, String userName, String password,
			String email, String phone, String role, boolean active) {
		super();
		this.userId = userId;
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", role=" + role + ", active=" + active + "]";
	}
	
}
