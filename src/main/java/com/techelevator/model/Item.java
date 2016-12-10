package com.techelevator.model;

public class Item {
	
	private int itemId;
	private String imageId;
	private String type;
	private String variety;
	private int harvestQnty;
	private DollarAmount price;
	private String description;
	private boolean isActive;
	
	public Item(){
		
	}

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

	public void setHarvestQnty(int harvestQnty) {
		this.harvestQnty = harvestQnty;
	}

	public void setPrice(DollarAmount price) {
		this.price = price;
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

	public int getHarvestQnty() {
		return harvestQnty;
	}

	public DollarAmount getPrice() {
		return price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	

}
