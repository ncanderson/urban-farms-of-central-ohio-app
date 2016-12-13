package com.techelevator.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class HarvestItem {
	private int harvestItemId;
	private int itemId;
	private int harvestQnty;
	private String harvestImageId;
	private String averageSize;
	private String availability;
	private String comments;
	private Date date;
	private BigDecimal price;
	private int reconciliationId;
	private String itemType;
	private String itemVariety;
	private String itemImageId;
	private String itemDescription;
	private String farmerEnteredPickComments;
	private LocalDate endDate;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getFarmerEnteredPickCommments() {
		return farmerEnteredPickComments;
	}
	public void setFarmerEnteredPickComments(String farmerEnteredPickComments) {
		this.farmerEnteredPickComments = farmerEnteredPickComments;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemVariety() {
		return itemVariety;
	}
	public void setItemVariety(String itemVariety) {
		this.itemVariety = itemVariety;
	}
	public String getItemImageId() {
		return itemImageId;
	}
	public void setItemImageId(String itemImageId) {
		this.itemImageId = itemImageId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getHarvestItemId() {
		return harvestItemId;
	}
	public void setHarvestItemId(int harvestItemId) {
		this.harvestItemId = harvestItemId;
	}
	public int getHarvestQnty() {
		return harvestQnty;
	}
	public void setHarvestQnty(int harvestQnty) {
		this.harvestQnty = harvestQnty;
	}
	public String getHarvestImageId() {
		return harvestImageId;
	}
	public void setHarvestImageId(String harvestImageId) {
		this.harvestImageId = harvestImageId;
	}
	public String getAverageSize() {
		return averageSize;
	}
	public void setAverageSize(String averageSize) {
		this.averageSize = averageSize;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReconciliationId() {
		return reconciliationId;
	}
	public void setReconciliationId(int reconciliationId) {
		this.reconciliationId = reconciliationId;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
		
}
