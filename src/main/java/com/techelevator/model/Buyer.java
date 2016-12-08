package com.techelevator.model;

public class Buyer {//TODO should this extend the user class???

		int buyerID;
		String buyerName;
		String address1;
		String address2;
		String city;
		String stateCode;
		int zipCode;
		String deliveryTime;
		String contactPhone;
		String notes;
		boolean isActive;
		String description;
		boolean applyLargeOrderDiscount;
		float discount;
		
		public Buyer(){
			
		}

		public int getBuyerID() {
			return buyerID;
		}

		public void setBuyerID(int buyerID) {
			this.buyerID = buyerID;
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

		public String getDeliveryTime() {
			return deliveryTime;
		}

		public void setDeliveryTime(String deliveryTime) {
			this.deliveryTime = deliveryTime;
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

		public boolean isApplyLargeOrderDiscount() {
			return applyLargeOrderDiscount;
		}

		public void setApplyLargeOrderDiscount(boolean applyLargeOrderDiscount) {
			this.applyLargeOrderDiscount = applyLargeOrderDiscount;
		}

		public float getDiscount() {
			return discount;
		}

		public void setDiscount(float discount) {
			this.discount = discount;
		}
		
		
}
