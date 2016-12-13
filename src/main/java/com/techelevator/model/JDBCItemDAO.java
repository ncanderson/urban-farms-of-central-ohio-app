package com.techelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JDBCItemDAO implements ItemDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCItemDAO(DataSource dataSource){
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertItem(String imageId, String type, String variety, int harvestQnty, DollarAmount price) {
	
			//TODO
	}

	@Override
	public List<Item> allCurrentHarvestItems() {
		
		String sqlSelectStatement = "SELECT item_image_id, item_type, item_id, item_variety, item_price, harvest_quantity " 
									+"FROM item "
									+"INNER JOIN item_price "
									+"ON item.item_id = item_price.item_id "
									+"INNER JOIN item_harvest_details "
									+"ON item.item_id = item_harvest_details.item_id";
			
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);
				
		return mapResultsToItemList(results);
	}

	@Override
	public List<Item> allAvailableCropsList() {
		//TODO fix this method
		String sqlSelectStatement = "SELECT item_image_id, item.item_id, item_type, item_variety, item_price, harvest_quantity " 
				+"FROM item "
				+"INNER JOIN item_price "
				+"ON item.item_id = item_price.item_id "
				+"INNER JOIN item_harvest_details "
				+"ON item.item_id = item_harvest_details.item_id "
				+"WHERE harvest_quantity > 0";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);

		return mapResultsToItemList(results);
	}

	@Override
	public Item getCropById(int id) {
		
		String sqlSelectStatement = "SELECT item_image_id, item_type, item.item_id, item_variety, item_price, harvest_quantity "
									+"FROM item "
									+"INNER JOIN item_harvest_details "
									+"ON item.item_id = item_harvest_details.item_id "
									+"WHERE item.item_id = ?"; 
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement, id);
		
		return mapResultsToItemList(results).get(0);
	}
	
	@Override
	public Item getAdminCropById(int id) {
		
		String sqlSelectStatement = "SELECT  item_type, item_variety, item_description, is_active "
									+"FROM item "
									+"WHERE item.item_id = ?"; 
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement, id);
		
		return mapResultsToAdminEditItem(results);
	}
	
	@Override 
	public Item getCropByTypeAndVariety(String type, String variety) {
		Item cropToFind = new Item();
		String sqlSelectStatement; 
		
		if (variety == null) {
			variety = "";
		}
		sqlSelectStatement = "SELECT * "
				             + "FROM item "
				             + "WHERE item_type = ? AND item_variety = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement, type, variety);
		
		while (results.next()) {
			cropToFind.setItemId(results.getInt("item_id"));
			cropToFind.setType(results.getString("item_type"));
			cropToFind.setVariety(results.getString("item_variety"));
			cropToFind.setImageId(results.getString("item_image_id"));
		}
		
		return cropToFind;
	}
	
	@Override
	public List<Item> allCropsInDatabase() {
		
		String sqlSelectStatement = "SELECT * "
									+ "FROM item";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);
		
		return mapResultsToItemList(results);

	}
	
	@Override
	public List<String> selectAllUniqueCropsByType() {
		 
		String sqlSelectStatement = "SELECT DISTINCT item_type "
									+ "FROM item "
									+ "ORDER BY item_type";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);
		
		List<String> distinctCropTypes = new ArrayList<String>();
		
		while(results.next()) {
			String itemType = results.getString("item_type");
			distinctCropTypes.add(itemType);
		}
		return distinctCropTypes;
	}
	
	@Override
	public List<String> selectAllVarietiesByCropType(String type) {
		
		String sqlSelectStatement = "SELECT item_variety "
									+ "FROM item "
									+ "WHERE item_type = ? "
									+ "ORDER BY item_variety";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement, type);
		
		List<String> varietiesByType = new ArrayList<String>();
		
		while (results.next()) {
			String itemVariety = results.getString("item_variety");
			varietiesByType.add(itemVariety);
		}
		
		return varietiesByType;
	}
	
	@Override 
	public List<Item> findAllCropsByType(String chosenType) {
		
		String sqlSelectStatement = "SELECT * "
									+ "FROM item "
									+ "WHERE item_type = ? "
									+ "ORDER BY item_variety";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement, chosenType);
		
		List<Item> itemsByType = new ArrayList<Item>();
		
		while (results.next()) {
			Item item = new Item();
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));
			itemsByType.add(item);
		}
		
		return itemsByType;
	}
	
	@Override
	public List<Item> getAllActiveCrops() {
		// TODO Auto-generated method stub
		
		String sqlSelectStatment = "SELECT  item_id, item_image_id, item_type, item_variety "
									+"FROM item "
									+"WHERE item.is_active= true"; 
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
		
		List<Item> activeCrops = new ArrayList<Item>();
		while(results.next()){
			Item item = new Item();
			item.setItemId((results.getInt("item_id")));
			item.setImageId(results.getString("item_image_id"));
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));

			activeCrops.add(item);
		}
		return activeCrops;
	}
	
	@Override
	public void updateItem(Item item, int itemId) {
		//TODO missing season dates
		String sqlUpdateStatment = "UPDATE item SET item_type = ?, item_variety = ?, item_description = ?, is_active = ? WHERE item_id = ?";
		jdbcTemplate.update(sqlUpdateStatment, item.getType(), item.getVariety(), item.getDescription(), item.isActive(), itemId);
		
	}
	
	@Override
	public void addNewItem(Item item) {
		//TODO missing season dates
		String sqlInsertStatment = "INSERT INTO item (item_type, item_variety, item_description, is_active) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertStatment, item.getType(), item.getVariety(), item.getDescription(), item.isActive());
		
	}
	
	private List<Item> mapResultsToItemList(SqlRowSet results){
		
		List<Item> allCrops = new ArrayList<Item>();

		while(results.next()){
			
			Item item = new Item();
			item.setItemId(results.getInt("item_id"));
			item.setImageId(results.getString("item_image_id"));
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));
		
			allCrops.add(item);		
		}		
		return allCrops;
	}
	
	private Item mapResultsToAdminEditItem(SqlRowSet results){
		
		Item item = new Item();

		while(results.next()){
			
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));
			item.setDescription(results.getString("item_description"));
			item.setActive(Boolean.valueOf(results.getString("is_active")));
		}
		
		return item;	
	}

	
	

	
}
