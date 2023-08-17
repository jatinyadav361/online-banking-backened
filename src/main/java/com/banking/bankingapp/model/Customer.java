package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


@Entity
@Table(name="CustomerInfo")
public class Customer {
	@Id
	@Column(length=20,unique=true)
	private String username;
	
	@NotBlank(message="Customer name cannnot be blank")
	private String name;
	
	@Email
	private String email;
	
	@Length(min=8,max=30,message="Password must be between 8-30 characters")
	private String password;
	
	@Length(min=10,max=10,message="Mobile Number must be of 10 digits")
	@Pattern(regexp="^[0-9]+$", message="Mobile number can only contain digits")
	private String mobileNo;
	
	@Length(min=12,max=12,message="Aadhar Number must be of 12 digits")
	@Pattern(regexp="^[0-9]+$", message="Aadhar number can only contain digits")
	private String aadhar;
	
	@NotBlank(message="Address cannnot be blank")
	private String address;
	
	@Length(min=6,max=6,message="Pin code must be of 6 digits")
	@Pattern(regexp="^[0-9]+$", message="Pin code can only contain digits")
	private String pincode;
	
	@NotBlank(message="State field cannot be blank")
	private String state;
	
	@NotBlank(message="District field cannnot be blank")
	private String district;
	
//	@Length(min=10,max=10,message="Pin code must be of 10 characters")
	private String pan;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER, cascade = CascadeType.ALL )
	private List<Account> account;
	

	
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
		
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