package com.learning.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionNumber;
	private double amount;
	private String accountType;
	private Date transactionDate;
	private String reference;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tranAccountNumber", referencedColumnName="account_number")
	private Account account; //many transactions can be added from the same account
	

	//getter and setter
	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Transaction() {
		super();
		
	}
	
	public Account getAccount() {
		return account;
	}

	
}
