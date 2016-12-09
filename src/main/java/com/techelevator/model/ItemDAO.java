package com.techelevator.model;

import java.util.List;

public interface ItemDAO {

	public void insertItem(String imageId, String type, String variety, int harvestQnty, DollarAmount price);

	public List<Item> allCurrentHarvestItems();
	
	public List<Item> allAvailableCropsList();
	
	public Item getCropById(int id);

	public List<Item> allCropsInDatabase();

	public List<String> selectAllUniqueCropsByType();
}
