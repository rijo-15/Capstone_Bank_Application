package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BId") //is a primary key
	private long BId;
	@Column(name="SSN", unique=true, nullable=false)
	private long ssn;
	@Column(name="BFirstName")
	private String bfirstName;
	@Column(name="BLastName")
	private String lastName;
	@Column(name="BUserName", unique=true, nullable=false)
	private String username;
	@Column(name="Password", nullable=false)
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Phone")
	private String phone;
	@Column(name="approved", columnDefinition = "varchar(255) default 'no'") 
	private String approved; //yes or no
	
	// idea a Beneficiary can have one user to be dependent on, but the user can have multiple Beneficiary
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName="UserId")
	private User user;
	
	
	public long getBId() {
		return BId;
	}
	public void setBId(long bId) {
		BId = bId;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getBfirstName() {
		return bfirstName;
	}
	public void setBfirstName(String bfirstName) {
		this.bfirstName = bfirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public Beneficiary() {
		super();
		
	}
	public Beneficiary(long bId, long ssn, String bfirstName, String lastName, String username, String password,
			String email, String phone) {
		super();
		BId = bId;
		this.ssn = ssn;
		this.bfirstName = bfirstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Beneficiary [BId=" + BId + ", ssn=" + ssn + ", bfirstName=" + bfirstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
	
	//ManyToOne User getter method
	public User getUser() {
		return user;
	}
	public void addBenficaryToUser(User user) {
		this.user = user;
	}
	
	
}
