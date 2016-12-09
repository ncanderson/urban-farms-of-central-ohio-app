package com.techelevator.model;

import java.util.List;

public interface ItemDAO {

	public void insertItem(String imageId, String type, String variety, int harvestQnty, DollarAmount price);

	public List<Item> allCropsList();
	
	public List<Item> allAvailableCropsList();



}
