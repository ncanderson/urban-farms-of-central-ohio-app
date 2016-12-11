package com.techelevator.model;



public class CartItem {

	private int quantity;
	private Item cropItem;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item getCrop() {
		return cropItem;
	}
	public void setCrop(Item cropItem) {
		this.cropItem = cropItem;
	}	
	
}