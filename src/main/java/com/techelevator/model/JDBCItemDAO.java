package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
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
	public List<Item> allCropsList() {
		
		String sqlSelectStatement = "SELECT item_image_id, item_type, item_variety, item_price, harvest_quantity " 
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
		String sqlSelectStatement = "SELECT item_image_id, item_type, item_variety, item_price, harvest_quantity " 
				+"FROM item "
				+"INNER JOIN item_price "
				+"ON item.item_id = item_price.item_id "
				+"INNER JOIN item_harvest_details "
				+"ON item.item_id = item_harvest_details.item_id"
				+"WHERE harvest_quantity > 0";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);

		return mapResultsToItemList(results);
	}

	@Override
	public Item getCropById(int id) {
		
		String sqlSelectStatement = ""; //TODO finish method
		return null;
	}
	
	
	private List<Item> mapResultsToItemList(SqlRowSet results){
		
		List<Item> itemList = new ArrayList<Item>();
		while(results.next()){
			
			Item item = new Item();
			item.setImageId(results.getString("item_image_id"));
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));
			item.setHarvestQnty(results.getInt("harvest_quantity"));

			float tempFloat = results.getBigDecimal("item_price").floatValue();
			int tempInt = Math.round(100*tempFloat);
			DollarAmount price = new DollarAmount(tempInt);
			
			item.setPrice(price);
			
			itemList.add(item);		
		}
		return itemList;
	}
}
