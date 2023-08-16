package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name="AccountInfo")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_generator")
	@SequenceGenerator(name="account_generator", sequenceName="account_seq",initialValue=1000000000, allocationSize=1)
	private long accountNo;
	
	private String balance;
	
	private String accountType;
	
	private String ifsc;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Customer customer;
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
}
