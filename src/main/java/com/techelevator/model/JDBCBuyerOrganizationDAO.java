package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCBuyerOrganizationDAO implements BuyerOrganizationDAO {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCBuyerOrganizationDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	
	@Override
	public BuyerOrganization getBuyerOrganizationById(int buyerId) {
		
		String sqlQuery = "SELECT * "
						  + "FROM buyer_information "
						  + "WHERE buyer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, buyerId); 
		
		return mapResultsToBuyerOrganization(results).get(0);
	}

	private List<BuyerOrganization> mapResultsToBuyerOrganization(SqlRowSet results) {
		List<BuyerOrganization> returnedBuyerOrganizations = new ArrayList<BuyerOrganization>();
		
		while (results.next()) {
			BuyerOrganization buyerOrg = new BuyerOrganization();
			buyerOrg.setBuyerId(results.getInt("buyer_id"));
			buyerOrg.setBuyerName(results.getString("buyer_name"));
			buyerOrg.setAddress1(results.getString("address1"));
			buyerOrg.setAddress2(results.getString("address2"));
			buyerOrg.setCity(results.getString("city"));
			buyerOrg.setStateCode(results.getString("state_code"));
			buyerOrg.setZipCode(results.getInt("zipcode"));
			buyerOrg.setDeliveryTimes(results.getString("delivery_times"));
			buyerOrg.setContactPhone(results.getString("contact_phone"));
			buyerOrg.setNotes(results.getString("notes"));
			buyerOrg.setActive(results.getBoolean("is_active"));
			buyerOrg.setDescription(results.getString("description"));
			buyerOrg.setLargeOrderDiscount(results.getBoolean("apply_large_order_discount"));
			buyerOrg.setDiscount(results.getDouble("discount"));

			returnedBuyerOrganizations.add(buyerOrg);
		}
			
		return returnedBuyerOrganizations;
	}
	
}
