package com.banking.bankingapp.model;

import java.util.Date;

public class CustomerDTO {

	private String username;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String email;
	private String password;
	private String mobileNo;
	private String aadhar;
	private String addressLine1;
	private String addressLine2;
	private String landmark;
	private String pincode;
	private String state;
	private String district;
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
	private String pan;
	private boolean active;
	private boolean locked;
	private Date dob;
	private boolean admin;
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
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
}
