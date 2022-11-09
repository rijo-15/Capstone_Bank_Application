package com.learning.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
	@Column(name="date_of_creation")
	@CreatedDate
	private Date dateOfCreation;
	@Column(name="customer_id") //need to remove this since we have a relationship now
	private long customerId;
	
	@Column(name="status", columnDefinition= "varchar(255) default 'null'") //"enabled"
	private String status;
	
	@Column(name="approved", columnDefinition = "varchar(255) default 'no'")  //by default not
	private String approved; //yes or no
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="refcustomer_id", referencedColumnName="UserId")
	private User userAcc; //many account can belongs to one customer
	
	@JsonIgnore
	@OneToMany(mappedBy="")
	Set<Transaction> transactions = new HashSet<>(); //one account can add make many transactions
	
	
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
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
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
	public Account(long accountNumber, AccountType accountType, double accountBalance, String approved,
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
	//transaction getter method
		public Set<Transaction> getTransactions() {
			return transactions;
		}
}
