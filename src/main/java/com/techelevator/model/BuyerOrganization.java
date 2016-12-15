package com.techelevator.model;

public class BuyerOrganization {
	
	private int buyerId;
	private String buyerName;
	private String address1;
	private String address2;
	private String city;
	private String stateCode;
	private int zipCode;
	private String deliveryTimes;
	private String contactPhone;
	private String notes;
	private boolean isActive;
	private String description;
	private boolean largeOrderDiscount;
	private double discount;
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getDeliveryTimes() {
		return deliveryTimes;
	}
	public void setDeliveryTimes(String deliveryTimes) {
		this.deliveryTimes = deliveryTimes;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isLargeOrderDiscount() {
		return largeOrderDiscount;
	}
	public void setLargeOrderDiscount(boolean largeOrderDiscount) {
		this.largeOrderDiscount = largeOrderDiscount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
