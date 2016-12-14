package com.techelevator.model;

public class User {
	
	public enum Type {ADMIN, FARMER, BUYER};
	private Type type;
	private int userID;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private boolean isGlobalAdmin;
	private boolean isAdmin;
	private boolean isActive;
	private String companyName;
	private boolean resetPassword; 
	
	public User(){
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isGlobalAdmin() {
		return isGlobalAdmin;
	}

	public void setGlobalAdmin(boolean isGlobalAdmin) {
		this.isGlobalAdmin = isGlobalAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}
	
	
	
	

}
