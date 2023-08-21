package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

import java.time.ZonedDateTime;
import java.util.Date;


@Entity
@Table(name="TransactionInfo")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transaction_generator")
	@SequenceGenerator(name="transaction_generator", sequenceName="transaction_seq",initialValue=1000000000, allocationSize=1)
	private long transactionId;
	private ZonedDateTime timestamp;
	private Date date;
	private double tAmount;
	private String tType; // debit or credit
	
	@ManyToOne
	@JoinColumn(name="senderAccount")
	private Account senderAccount;
	
	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}
	public Account getRecieverAccount() {
		return recieverAccount;
	}
	public void setRecieverAccount(Account recieverAccount) {
		this.recieverAccount = recieverAccount;
	}
	@ManyToOne
	@JoinColumn(name="recieverAccount")
	private Account recieverAccount;
	
	private String tMode; // transaction mode RTGS, NEFT, IMPS, Cash Withdrawl, Self Transfer
	private double instBalance;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double gettAmount() {
		return tAmount;
	}
	public void settAmount(double tAmount) {
		this.tAmount = tAmount;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	
	public String gettMode() {
		return tMode;
	}
	public void settMode(String tMode) {
		this.tMode = tMode;
	}
	public double getInstBalance() {
		return instBalance;
	}
	public void setInstBalance(double instBalance) {
		this.instBalance = instBalance;
	}
	
}
