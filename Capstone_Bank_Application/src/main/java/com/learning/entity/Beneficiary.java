package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficiary {
	
	@Id
	private long accountNumber;
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	public Beneficiary() {
		super();
		
	}
	public Beneficiary(long accountNumber, String beneficiaryFirstName, String beneficiaryLastName) {
		super();
		this.accountNumber = accountNumber;
		this.beneficiaryFirstName = beneficiaryFirstName;
		this.beneficiaryLastName = beneficiaryLastName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}
	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}
	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}
	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}
	@Override
	public String toString() {
		return "Beneficiary [accountNumber=" + accountNumber + ", beneficiaryFirstName=" + beneficiaryFirstName
				+ ", beneficiaryLastName=" + beneficiaryLastName + "]";
	}
	
	
}
