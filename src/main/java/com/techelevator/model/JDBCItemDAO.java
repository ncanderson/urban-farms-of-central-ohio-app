package com.techelevator.model;

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
		// note this is a harvest image id
		//TODO might be better to use a "TRANSACTION" 
		String sqlItemInsert = "INSERT INTO item (item_type, item_variety, item_image_id) VALUES (?, ?, ?)";
		String sqlHarvestInsert = "INSERT INTO item_harvest_details (harvest_quantity) VALUES ( ? )";
		String sqlInsertPrice = "INSERT INTO item_price (item_price) VALUES ( ?, ? )";
		
//		  item_price_id serial PRIMARY KEY,
//		  item_id integer NOT NULL,
//		  date_added timestamp NOT NULL,
//		  sale_type_id integer NOT NULL,
//		  item_price money NOT NULL
//		
//		  item_id serial PRIMARY KEY,
//		  item_type varchar(25) NOT NULL,
//		  item_variety varchar(25) NULL,
//		  item_image_id varchar(50) NULL,
//		  item_description varchar(150) NULL
//		  
//		  item_harvest_details_id serial PRIMARY KEY,
//		  item_id integer NOT NULL REFERENCES item,
//		  harvest_quantity integer NOT NULL,
//		  item_price_id integer NULL REFERENCES item_price,
//		  harvest_image_id varchar(25) NULL,
//		  average_size_of_item varchar(100) NULL,
//		  harvest_details_comments varchar(150) NULL,
//		  harvest_date timestamp NOT NULL
	}

	

}
