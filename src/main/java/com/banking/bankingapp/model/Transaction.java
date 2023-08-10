package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.Column;


@Entity
@Table(name="TransactionInfo")
public class Transaction {
	@Id
	@Column(name="transactionId",length=11,unique=true)
	private String tId;
	private Date date;
	private String tAmount;
	private String tType; // debit or credit
	private String fromAccNo;
	private String toAccNo;
	private String tMode; // transaction mode
	private String instBalance;
	
	public String getFromAccNo() {
		return fromAccNo;
	}
	public void setFromAccNo(String fromAccNo) {
		this.fromAccNo = fromAccNo;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String gettAmount() {
		return tAmount;
	}
	public void settAmount(String tAmount) {
		this.tAmount = tAmount;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public String getToAccNo() {
		return toAccNo;
	}
	public void setToAccNo(String toAccNo) {
		this.toAccNo = toAccNo;
	}
	public String gettMode() {
		return tMode;
	}
	public void settMode(String tMode) {
		this.tMode = tMode;
	}
	public String getInstBalance() {
		return instBalance;
	}
	public void setInstBalance(String instBalance) {
		this.instBalance = instBalance;
	}
	
}
