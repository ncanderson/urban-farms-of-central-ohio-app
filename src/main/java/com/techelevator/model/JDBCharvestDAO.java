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
				int tempPrice = Math.round(results.getBigDecimal("price").floatValue()*100);
			item.setPrice(new DollarAmount(tempPrice));
			item.setImageId(results.getString("item_image_id"));//TODO account for image ID null occurrence
			harvestItems.add(item);
		}
		
		return harvestItems;
	}

	@Override
	public void addHarvestItem(Harvest newHarvestItem) {
		String sqlInsertHarvestItem = "INSERT INTO item_harvest_details(item_id, harvest_quantity, harvest_date, average_size_of_item, harvest_availability, harvest_details_comments) " +
										"VALUES(?,?,?)";
		
	}
}
