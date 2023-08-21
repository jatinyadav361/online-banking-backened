package com.banking.bankingapp.model;

public class AccountFetch {
	
	private long accountNo;
	
	private double balance;
	
	private String accountType; // 0 for 'Savings', 1 for 'Current', 2 for 'Salary'
	
	private String ifsc;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
}
