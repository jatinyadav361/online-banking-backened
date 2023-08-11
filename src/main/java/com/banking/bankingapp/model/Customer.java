package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
@Table(name="CustomerInfo")
public class Customer {
	@Id
	@Column(length=20,unique=true)
	private String username;
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private String aadhar;
	private String address;
	private String pan;
	@Column(length=11,unique=true)
	private String accountNo;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
}



//{
//    "accountNo": "98345619823",
//    "username": "user2",
//    "name": "Test",
//    "email": "test@gmail.com",
//    "password": "test@123",
//    "mobileNo": "9273262662",
//    "aadhar": "25o6488383",
//    "address": "Test, Bengaluru",
//    "pan": "BHID8936826"
//}