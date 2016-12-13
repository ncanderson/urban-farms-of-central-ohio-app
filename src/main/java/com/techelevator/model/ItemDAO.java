package com.techelevator.model;

import java.util.List;

public interface ItemDAO {

	public void insertItem(String imageId, String type, String variety, int harvestQnty, DollarAmount price);

	public List<Item> allCurrentHarvestItems();
	
	public List<Item> allAvailableCropsList();
	
	public Item getCropById(int id);
	
	public Item getAdminCropById(int id);
	
	public Item getCropByTypeAndVariety(String type, String variety);

	public List<Item> allCropsInDatabase();

	public List<String> selectAllUniqueCropsByType();
	
	public List<String> selectAllVarietiesByCropType(String type);
	
	public List<Item> findAllCropsByType(String chosenType);

	public List<Item> getAllActiveCrops();
	
	public void updateItem(Item item, int itemId);

}
