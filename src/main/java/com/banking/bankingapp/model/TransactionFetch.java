package com.banking.bankingapp.model;

import java.util.Date;

public class TransactionFetch {

	private long transactionId;
	private Date date;
	private double tAmount;
	private String tType;
	private long senderAccountId;
	private long recieverAccountId;
	private String tMode; // transaction mode RTGS, NEFT, IMPS, Cash Withdrawl, Self Transfer
	private double instBalance;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
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
	public long getSenderAccountId() {
		return senderAccountId;
	}
	public void setSenderAccountId(long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}
	public long getRecieverAccountId() {
		return recieverAccountId;
	}
	public void setRecieverAccountId(long recieverAccountId) {
		this.recieverAccountId = recieverAccountId;
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
