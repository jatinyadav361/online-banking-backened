package com.banking.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


@Entity
@Table(name="CustomerInfo")
public class Customer {
	@Id
	@Column(unique=true)
	@Length(min=8, max=20)
	private String username;
	private int incorrectPassAttempt;
	private boolean active;
	private boolean locked;
	
	private boolean admin;
	
	@NotBlank(message="Customer title cannnot be blank")
	private String title;
	
	@NotBlank(message="Customer first name cannnot be blank")
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message="Customer last name cannnot be blank")
	private String lastName;
	
	@NotBlank(message="Customer's father name cannnot be blank")
	private String fatherName;
	
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
	private String addressLine1;
	@NotBlank(message="Address cannnot be blank")
	private String addressLine2;
	private String landmark;
	private Date dob;
	
	private boolean samePermanentAddress;
	
	private String addressLine1P;
	private String addressLine2P;
	private String landmarkP;
	private String pincodeP;
	private String stateP;
	private String districtP;
	
	
	private String occupationType;
	private String occupation;
	private String annualIncome;
	
	private boolean netBankingOpted;
	private boolean debitCardOpted;

	
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public boolean isSamePermanentAddress() {
		return samePermanentAddress;
	}
	public void setSamePermanentAddress(boolean samePermanentAddress) {
		this.samePermanentAddress = samePermanentAddress;
	}
	public String getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public boolean isNetBankingOpted() {
		return netBankingOpted;
	}
	public void setNetBankingOpted(boolean netBankingOpted) {
		this.netBankingOpted = netBankingOpted;
	}
	public boolean isDebitCardOpted() {
		return debitCardOpted;
	}
	public void setDebitCardOpted(boolean debitCardOpted) {
		this.debitCardOpted = debitCardOpted;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getAddressLine1P() {
		return addressLine1P;
	}
	public void setAddressLine1P(String addressLine1P) {
		this.addressLine1P = addressLine1P;
	}
	public String getAddressLine2P() {
		return addressLine2P;
	}
	public void setAddressLine2P(String addressLine2P) {
		this.addressLine2P = addressLine2P;
	}
	public String getLandmarkP() {
		return landmarkP;
	}
	public void setLandmarkP(String landmarkP) {
		this.landmarkP = landmarkP;
	}
	public String getPincodeP() {
		return pincodeP;
	}
	public void setPincodeP(String pincodeP) {
		this.pincodeP = pincodeP;
	}
	public String getStateP() {
		return stateP;
	}
	public void setStateP(String stateP) {
		this.stateP = stateP;
	}
	public String getDistrictP() {
		return districtP;
	}
	public void setDistrictP(String districtP) {
		this.districtP = districtP;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public int getIncorrectPassAttempt() {
		return incorrectPassAttempt;
	}
	public void setIncorrectPassAttempt(int incorrectPassAttempt) {
		this.incorrectPassAttempt = incorrectPassAttempt;
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