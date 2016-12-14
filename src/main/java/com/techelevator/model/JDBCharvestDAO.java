package com.techelevator.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JDBCharvestDAO implements HarvestDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCharvestDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	@Override
	public List<HarvestItem> getHarvestItemList() {
		
		String sqlSelectAllHarvestItems = "SELECT item.*, item_harvest_details.* "
										+ "FROM item_harvest_details "
										+ "INNER JOIN item ON item.item_id = item_harvest_details.item_id "
										+ "WHERE harvest_quantity > 0";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllHarvestItems);

		return mapResultsToHarvestItemList(results);
	}

	@Override
	public void addHarvestItem(HarvestItem newHarvestItem) {
		
		int itemId = newHarvestItem.getItemId();
		int harvestQnty = newHarvestItem.getHarvestQnty();
//		String harvestImageId = newHarvestItem.getHarvestImageId();
		String averageSize = newHarvestItem.getAverageSize();
		String availability = newHarvestItem.getAvailability();
		String comments = newHarvestItem.getComments();
		String pickListComments = newHarvestItem.getFarmerEnteredPickComments();
		BigDecimal price = newHarvestItem.getPrice();
		LocalDate endDate = newHarvestItem.getEndDate();
		
		String sqlInsertQuery = "INSERT INTO item_harvest_details"
								+ "(item_id, harvest_quantity, average_size_of_item, harvest_availability, "
								+ "harvest_details_comments, pick_list_comments, item_price, harvest_end_date) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sqlInsertQuery, itemId, harvestQnty, averageSize, availability, comments, pickListComments, price, endDate);		
	}
	
	@Override
	public void updateHarvestItem(HarvestItem updateHarvestItem) {
		
		int itemId = updateHarvestItem.getItemId();
		int harvestItemId = updateHarvestItem.getHarvestItemId();
		int harvestQnty = updateHarvestItem.getHarvestQnty();
//		String harvestImageId = updateHarvestItem.getHarvestImageId();
		String averageSize = updateHarvestItem.getAverageSize();
		String availability = updateHarvestItem.getAvailability();
		String comments = updateHarvestItem.getComments();
		String pickListComments = updateHarvestItem.getFarmerEnteredPickComments();
		BigDecimal price = updateHarvestItem.getPrice();
		LocalDate endDate = updateHarvestItem.getEndDate();
		int recId = updateHarvestItem.getReconciliationId();
		
		
		
		
		String sqlInsertQuery = "INSERT INTO item_harvest_details"
								+ "(item_id, harvest_quantity, average_size_of_item, harvest_availability, "
								+ "harvest_details_comments, pick_list_comments, item_price, harvest_end_date, harvest_reconciliation_id) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sqlInsertQuery, itemId, harvestQnty, averageSize, availability, comments, pickListComments, price, endDate, recId);
		
		String sqlUpdateQuery = "UPDATE item_harvest_details "
								+ "SET harvest_quantity = 0 "
								+ "WHERE item_harvest_details_id = ?";
			
		jdbcTemplate.update(sqlUpdateQuery, harvestItemId);
		

	}
	
	@Override
	public HarvestItem getHarvestItemById(int harvestItemId) {
		
		String sqlQuery = "SELECT * " 
						  + "FROM item_harvest_details "
						  + "INNER JOIN item " 
						  + "ON item_harvest_details.item_id = item.item_id " 
						  + "WHERE item_harvest_details_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, harvestItemId);
		
		return mapResultsToHarvestItemList(results).get(0);
	}

	@Override
	public List<HarvestItem> getAllHarvestItems() {
		
		String sqlQuery = "SELECT * " 
				  		  + "FROM item_harvest_details "
				  		  + "INNER JOIN item " 
				  		  + "ON item_harvest_details.item_id = item.item_id";
		
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
			foundItem.setDateAdded(results.getDate("harvest_date"));
			foundItem.setReconciliationId(results.getInt("harvest_reconciliation_id"));
			foundItem.setItemType(results.getString("item_type"));
			foundItem.setItemVariety(results.getString("item_variety"));
			foundItem.setItemDescription(results.getString("item_description"));
			foundItem.setPrice(results.getBigDecimal("item_price"));
			foundItem.setFarmerEnteredPickComments(results.getString("pick_list_comments"));
			
			foundItem.setHarvestImageId(results.getString("harvest_image_id"));
			if (foundItem.getHarvestImageId() == null || foundItem.getHarvestImageId().equals("")) {
				foundItem.setHarvestImageId("default-photo-veggies.jpg");				
			}
			
			harvestItemResults.add(foundItem);
		}
		
		return harvestItemResults;
	}

	@Override
	public BigDecimal getCurrentItemPrice(int itemId) {
		String sqlQuery = "SELECT item_price, harvest_date "
						+ "FROM item_harvest_details "
						+ "WHERE item_id = ? "
						+ "ORDER BY harvest_date desc "
						+ "LIMIT 1";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, itemId);
		
		HarvestItem itemToPrice = new HarvestItem();
		while (results.next()) {
			itemToPrice.setPrice(results.getBigDecimal("item_price"));
		}
		
		return itemToPrice.getPrice();
	}

}
