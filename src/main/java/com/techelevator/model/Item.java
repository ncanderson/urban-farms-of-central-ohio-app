package com.techelevator.model;

import java.time.LocalDate;

public class Item {
	
	private int itemId;
	private String imageId;
	private String type;
	private String variety;
	private String description;
	private boolean isActive;
	private LocalDate startDate1;
	private LocalDate endDate1;
	private LocalDate startDate2;
	private LocalDate endDate2;
	private LocalDate startDate3;
	private LocalDate endDate3;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getImageId() {
		return imageId;
	}

	public String getType() {
		return type;
	}

	public String getVariety() {
		return variety;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public LocalDate getStartDate1() {
		return startDate1;
	}

	public void setStartDate1(LocalDate startDate1) {
		this.startDate1 = startDate1;
	}

	public LocalDate getEndDate1() {
		return endDate1;
	}

	public void setEndDate1(LocalDate endDate1) {
		this.endDate1 = endDate1;
	}

	public LocalDate getStartDate2() {
		return startDate2;
	}

	public void setStartDate2(LocalDate startDate2) {
		this.startDate2 = startDate2;
	}

	public LocalDate getEndDate2() {
		return endDate2;
	}

	public void setEndDate2(LocalDate endDate2) {
		this.endDate2 = endDate2;
	}

	public LocalDate getStartDate3() {
		return startDate3;
	}

	public void setStartDate3(LocalDate startDate3) {
		this.startDate3 = startDate3;
	}

	public LocalDate getEndDate3() {
		return endDate3;
	}

	public void setEndDate3(LocalDate endDate3) {
		this.endDate3 = endDate3;
	}
	
	
	

}
