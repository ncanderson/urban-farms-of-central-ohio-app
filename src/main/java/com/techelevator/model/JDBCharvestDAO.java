package com.techelevator.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCharvestDAO implements HarvestDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCharvestDAO(DataSource dataSource) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	@Override
	public List<Item> getHarvestItemList() {
		
		List<Item> harvestItems = new ArrayList<Item>();
		String sqlselectAnonymousItems = "SELECT item_type, item_variety, harvest_quantity, item_price FROM item_harvest_details "
										 + "INNER JOIN item "
										 + "ON item_harvest_details.item_id = item.item_id "
										 + "INNER JOIN item_price "
										 + "ON item_harvest_details.item_id = item_price.item_id ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlselectAnonymousItems);
		
		while(results.next()) {
			Item item = new Item();
			item.setType(results.getString("type"));
			item.setHarvestQnty(results.getInt("harvest_quantity"));
			item.setVariety(results.getString("variety"));
			int tempPrice = Math.round(results.getBigDecimal("price").floatValue()*100);
			item.setPrice(new DollarAmount(tempPrice));
			item.setImageId(results.getString("item_image_id"));//TODO account for image ID null occurrence
			harvestItems.add(item);
		}
		
		return harvestItems;
	}

	@Override
	public void addHarvestItem(HarvestItem newHarvestItem) {
		
		int itemId = newHarvestItem.getItemId();
		int harvestQnty = newHarvestItem.getHarvestQnty();
		String harvestImageId = newHarvestItem.getHarvestImageId();
		String averageSize = newHarvestItem.getAverageSize();
		String availability = newHarvestItem.getAvailability();
		String comments = newHarvestItem.getComments();
		Date harvestDate = newHarvestItem.getDate();
		
		String sqlInsertQuery = "INSERT INTO item_harvest_details(item_id, harvest_quantity, harvest_image_id, " 
								+ "average_size_of_item, harvest_availability, harvest_details_comments, harvest_date)" 
								+ "VALUES(?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sqlInsertQuery, itemId, harvestQnty, harvestImageId, averageSize, availability, comments, harvestDate);
	}
	
	@Override
	public HarvestItem getHarvestItemById(int harvestItemId) {
		
		String sqlQuery = "SELECT * " 
						  + "FROM item_harvest_details "
						  + "INNER JOIN item " 
						  + "ON item_harvest_details.item_id = item.item_id " 
						  + "INNER JOIN item_price "
						  + "ON item_harvest_details.item_id = item_price.item_id "
						  + "WHERE item_harvest_details_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, harvestItemId);
		
		return mapResultsToHarvestItemList(results).get(0);
	}

	@Override
	public List<HarvestItem> getAllHarvestItems() {
		
		String sqlQuery = "SELECT * " 
				  		  + "FROM item_harvest_details "
				  		  + "INNER JOIN item " 
				  		  + "ON item_harvest_details.item_id = item.item_id " 
				  		  + "INNER JOIN item_price "
				  		  + "ON item_harvest_details.item_id = item_price.item_id ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		
		return mapResultsToHarvestItemList(results);
	}

	private List<HarvestItem> mapResultsToHarvestItemList(SqlRowSet results) {
		List<HarvestItem> harvestItemResults = new ArrayList<HarvestItem>();
		
		while (results.next()) {
			HarvestItem foundItem = new HarvestItem();
			foundItem.setHarvestItemId(results.getInt("item_harvest_details_id"));
			foundItem.setItemId(results.getInt("item_id"));
			foundItem.setHarvestQnty(results.getInt("harvest_quantity"));
			foundItem.setAverageSize(results.getString("average_size_of_item"));
			foundItem.setAvailability(results.getString("harvest_availability"));
			foundItem.setComments(results.getString("harvest_details_comments"));
			foundItem.setDate(results.getDate("harvest_date"));
			foundItem.setReconciliationId(results.getInt("harvest_reconciliation_id"));
			foundItem.setItemType(results.getString("item_type"));
			foundItem.setItemVariety(results.getString("item_variety"));
			foundItem.setItemDescription(results.getString("item_description"));
			
			// Set image ID to default if one is not provided to database
			
			foundItem.setHarvestImageId(results.getString("harvest_image_id"));
			if (foundItem.getHarvestImageId() == null) {
				foundItem.setHarvestImageId(results.getString("item_image_id"));				
			}
			
			harvestItemResults.add(foundItem);
		}
		
		return harvestItemResults;
	}

}
