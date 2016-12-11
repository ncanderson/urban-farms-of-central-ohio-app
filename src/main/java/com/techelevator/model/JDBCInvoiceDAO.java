package com.techelevator.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public List<Invoice> getAllInvoices() {

		List<Invoice> invoices = new ArrayList<Invoice>();
		String sqlSelectStatment = "SELECT invoice_id, invoice_date, buyer_name, invoice_status_name, sale_type_name "
								   + "FROM invoice INNER JOIN sale_type "
								   + "ON invoice.sale_type_id = sale_type.sale_type_id "
								   + "INNER JOIN invoice_status "
								   + "ON invoice_status.invoice_status_id = invoice.invoice_status_id "
								   + "INNER JOIN buyer_information "
								   + "ON invoice.buyer_id = buyer_information.buyer_id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
	
		while(results.next()) {	

			Invoice invoice = new Invoice();
			invoice.setDate(results.getTimestamp("invoice_date"));
			invoice.setInvoiceId(results.getInt("invoice_id"));
			invoice.setBuyerName(results.getString("buyer_name"));
			invoice.setStatus(results.getString("invoice_status_name"));
			invoice.setSaleType(results.getString("sale_type_name"));
			List<Item> items = getItemsByInvoiceId(results.getInt("invoice_id"));
			invoice.setItems(items);
			invoices.add(invoice);
		}
					
		return invoices;
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
	
	
	
	private List<Item> getItemsByInvoiceId(int invoiceId) {
		
		List<Item> items = new ArrayList<Item>();

		String sqlSelectStatemnt = "SELECT item.* "
								   + "FROM item "
								   + "INNER JOIN invoice_item ON item.item_id = invoice_item.item_id "
								   + "INNER JOIN invoice ON invoice.invoice_id = invoice_item.invoice_id "
								   + "WHERE invoice.invoice_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatemnt, invoiceId);
		
		while(results.next()){
			Item item = new Item();
			item.setItemId(results.getInt("item_id"));
			item.setImageId(results.getString("item_image_id"));
			item.setType(results.getString("item_type"));
			item.setVariety(results.getString("item_variety"));
			item.setDescription(results.getString("item_description"));
			item.setActive(results.getBoolean("is_active"));
			
			items.add(item);
		}
		return items;
	}
}
