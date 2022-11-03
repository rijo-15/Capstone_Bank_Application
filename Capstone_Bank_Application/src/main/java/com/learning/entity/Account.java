package com.learning.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	//my code
	//private String approved;

	@Column(name="date_of_creation")
	private LocalDateTime dateOfCreation;
	@Column(name="customer_id")
	private long customerId;
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
	
	//changed code
	/*public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}*/
	
	
	public LocalDateTime getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Account() {
		super();
		
	}
	public Account(long accountNumber, AccountType accountType, double accountBalance, boolean approved,
			 long customerId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = approved;
		this.dateOfCreation = LocalDateTime.now();
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", approved=" + approved + ", dateOfCreation=" + dateOfCreation + ", customerId="
				+ customerId + "]";
	}
	
	
}
