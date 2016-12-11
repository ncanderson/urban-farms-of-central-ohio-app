package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public interface HarvestDAO {
	
	public List<HarvestItem> getHarvestItemList();
	
	public void addHarvestItem(HarvestItem newHarvestItem);
	
	public HarvestItem getHarvestItemById(int harvestItemId);
	
	public List<HarvestItem> getAllHarvestItems();
	
}
