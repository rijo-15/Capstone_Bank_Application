package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payload")
public class Payload {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long payloadId;

	private long fromAccNumber;
	private long toAccNumber;
	private long amount;
	private String reason;
	private long byCustomerId;
	public long getPayloadId() {
		return payloadId;
	}
	public void setPayloadId(long payloadId) {
		this.payloadId = payloadId;
	}
	public long getFromAccNumber() {
		return fromAccNumber;
	}
	public void setFromAccNumber(long fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}
	public long getToAccNumber() {
		return toAccNumber;
	}
	public void setToAccNumber(long toAccNumber) {
		this.toAccNumber = toAccNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getByCustomerId() {
		return byCustomerId;
	}
	public void setByCustomerId(long byCustomerId) {
		this.byCustomerId = byCustomerId;
	}
	@Override
	public String toString() {
		return "Payload [payloadId=" + payloadId + ", fromAccNumber=" + fromAccNumber + ", toAccNumber=" + toAccNumber
				+ ", amount=" + amount + ", reason=" + reason + ", byCustomerId=" + byCustomerId + "]";
	}
	
	
	
}
