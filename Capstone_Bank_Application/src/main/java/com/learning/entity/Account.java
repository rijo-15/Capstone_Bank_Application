package com.learning.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_number")
	private long accountNumber;
	@Column(name="account_type") //is checking or saving
	private AccountType accountType;
	@Column(name="account_balance")
	private double accountBalance;
	@Column(name="approved") 
	private boolean approved; //yes or no
	@Column(name="date_of_creation")
	@CreatedDate
	private Date dateOfCreation;
	@Column(name="customer_id") //need to remove this since we have a relationship now
	private long customerId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="refcustomer_id", referencedColumnName="UserId")
	private User userAcc; //many account can belongs to one customer
	
	
	//setters and getters

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	//Relationship map getter
	public User getUserAcc() {
		return userAcc;
	}
	public Account() {
		super();
		
	}
	public Account(long accountNumber, AccountType accountType, double accountBalance, boolean approved,
			 long customerId, Date dateOfCreation) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = approved;
		this.dateOfCreation = dateOfCreation;
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", approved=" + approved + ", dateOfCreation=" + dateOfCreation + ", customerId="
				+ customerId + "]";
	}
	
	public void addAccountToUser(User userAcc) {
		this.userAcc = userAcc;
	}
}
