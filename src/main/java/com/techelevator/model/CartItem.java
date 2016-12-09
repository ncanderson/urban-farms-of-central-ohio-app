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
	public DollarAmount getTotal(){
		
		DollarAmount total = new DollarAmount(0);
		for(int i=0; i<quantity; i++){
			
			
			total = total.plus(cropItem.getPrice());
		}
		 
		return total;
		
	}
	
	
}