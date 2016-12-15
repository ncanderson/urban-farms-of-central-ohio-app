package com.techelevator.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

@Component  
public class JDBCInvoiceDAO implements InvoiceDAO {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCInvoiceDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Invoice getInvoiceById(int invoiceId)
	{
		String sqlStatement = "SELECT * FROM invoice "
							+ "INNER JOIN invoice_status "
				   			+ "ON invoice_status.invoice_status_id = invoice.invoice_status_id "
							+ "WHERE invoice_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlStatement, invoiceId);
		
		if(result.next()) {
			Invoice invoice = new Invoice();
			invoice.setInvoiceId(result.getInt("invoice_id"));
			invoice.setBuyerId(result.getInt("buyer_id"));
			invoice.setDate(result.getTimestamp("invoice_date"));
			invoice.setUserId(result.getInt("user_id"));
			invoice.setSaleType(result.getString("sale_type_id"));
			invoice.setStatus(result.getString("invoice_status_name"));
			return invoice;
		}
		
		return null;
	}
	
	@Override
	public List<Invoice> getAllInvoices() {

		List<Invoice> invoices = new ArrayList<Invoice>();
		String sqlSelectStatment = "SELECT invoice_id, invoice_date, buyer_name, invoice_status_name, sale_type_name "
								   + "FROM invoice INNER JOIN sale_type "
								   + "ON invoice.sale_type_id = sale_type.sale_type_id "
								   + "INNER JOIN invoice_status "
								   + "ON invoice_status.invoice_status_id = invoice.invoice_status_id "
								   + "INNER JOIN buyer_information "
								   + "ON invoice.buyer_id = buyer_information.buyer_id "
								   + "WHERE invoice_id > 1300";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
	
		while(results.next()) {	

			Invoice invoice = new Invoice();
			invoice.setDate(results.getTimestamp("invoice_date"));
			invoice.setInvoiceId(results.getInt("invoice_id"));
			invoice.setBuyerName(results.getString("buyer_name"));
			invoice.setStatus(results.getString("invoice_status_name"));
			invoice.setSaleType(results.getString("sale_type_name"));
			List<InvoiceItem> invoiceItems = getInvoiceItemsByInvoiceId(results.getInt("invoice_id"));
			invoice.setInvoiceItems(invoiceItems);
			invoices.add(invoice);
		}
					
		return invoices;
	}
	
	@Override
	public Invoice createNewInvoice(int userId, int buyerId){
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("invoice").usingGeneratedKeyColumns("invoice_id");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("user_id", userId);
        parameters.put("buyer_id", buyerId);
        parameters.put("invoice_status_id", 1);
        // execute insert
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        
        Invoice invoice = new Invoice();
		invoice.setInvoiceId(key.intValue());
		invoice.setBuyerId(buyerId);
		invoice.setUserId(userId);

		return invoice;
	}
	
	@Override
	public List<Invoice> getPastOrders() {
		
		List<Invoice> pastOrders = new ArrayList<Invoice>();
		List<Invoice> invoices = this.getAllInvoices();	
			
		for(Invoice invoice: invoices){
			String status = invoice.getStatus();
			if(status.equals("Paid") || status.equals("Delivered") || status.equals("Archived")){
				pastOrders.add(invoice);
			}
		}
				
		return pastOrders;	
	}

	@Override
	public List<Invoice> getPendingOrders() {
		
		List<Invoice> pendingOrders = new ArrayList<Invoice>();
		List<Invoice> invoices = this.getAllInvoices();	
		
		for(Invoice invoice: invoices){
			String status = invoice.getStatus();
			if(status.equals("Pending")){
				pendingOrders.add(invoice);
			}
		}
				
		return pendingOrders;					
	}
	
	public Invoice getPendingOrderForBuyer(int buyerId)
	{
		String sqlSelectStatment = "SELECT * "
								 + "FROM invoice "
								 + "INNER JOIN invoice_status "
								 + "ON invoice_status.invoice_status_id = invoice.invoice_status_id "
								 + "WHERE buyer_id = ? AND invoice.invoice_status_id = 1 "
								 + "ORDER BY invoice_date ASC "
								 + "LIMIT 1";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectStatment, buyerId);
		if(result.next()) {
			Invoice invoice = new Invoice();
			invoice.setInvoiceId(result.getInt("invoice_id"));
			invoice.setBuyerId(buyerId);
			invoice.setDate(result.getTimestamp("invoice_date"));
			invoice.setUserId(result.getInt("user_id"));
			invoice.setSaleType(result.getString("sale_type_id"));
			invoice.setStatus(result.getString("invoice_status_name"));
			return invoice;
		}
		
		return null;
	}
	
	@Override
	public void addItemToInvoice(Invoice invoice, HarvestItem item, int quantity) {
		String sqlStatement = "INSERT INTO invoice_item ("
				+ "invoice_id, invoice_quantity, item_harvest_details_id, user_id, "
				+ "invoice_item_status_id, item_id"
				+ ") VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlStatement, invoice.getInvoiceId(), quantity, item.getHarvestItemId(), invoice.getUserId(), 1, item.getItemId());
	}
	
	@Override
	public List<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId) {
		
		List<InvoiceItem> items = new ArrayList<InvoiceItem>();

		String sqlSelectStatemnt = "SELECT * "
									+ "FROM invoice_item "
									+ "WHERE invoice_id = ?";

		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatemnt, invoiceId);
		
		while(results.next()){
			InvoiceItem item = new InvoiceItem();
			item.setInvoiceItemId(results.getInt("invoice_item_id"));
			item.setInvoiceId(results.getInt("invoice_id"));
			item.setInvoiceQnty(results.getInt("invoice_quantity"));
			item.setHarvestDetailsId(results.getInt("item_harvest_details_id"));
			item.setUpdatedItemPrice(results.getBigDecimal("update_item_price"));
			item.setUserId(results.getInt("user_id"));
			item.setInvoiceItemStatusId(results.getInt("invoice_item_status_id"));
			item.setInvoiceOverridePrice(results.getBigDecimal("invoice_price_override"));
			item.setDateAddedToInvoice(results.getDate("added_to_invoice_date"));
					
			items.add(item);
		}
		return items;
	}
}
