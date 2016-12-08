package com.techelevator.model;

import java.util.ArrayList;
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
	public JDBCharvestDAO(DataSource dataSource){
		
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
		
		while(results.next()){
			Item item = new Item();
			item.setType(results.getString("type"));
			item.setHarvestQnty(results.getInt("harvest_quantity"));
			item.setVariety(results.getString("variety"));
			item.setPrice((DollarAmount)results.getObject("price"));//TODO figure out Money data type in SQL
			item.setImageId(results.getString("item_image_id"));//TODO account for image ID null occurrence
			harvestItems.add(item);
		}
		
		return harvestItems;
	}
}
