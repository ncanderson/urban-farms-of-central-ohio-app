package com.techelevator.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

public class JDBCinvoiceDAO implements InvoiceDAO {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCinvoiceDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Invoice> getAllInvoices() {
		
		List<Invoice> invoices = new ArrayList<Invoice>();
		String sqlSelectStatment = "SELECT invoice_id, invoice_date, buyer_id, buyer_name, status, sale_type FROM invoice "
				+ "INNER JOIN invoice_status "
				+ "ON invoice.invoice_status_id = invoice_status.invoice_status_id "
				+ "INNER JOIN sale_type"
				+ "ON invoice.sale_type_id = sale_type.sale_type_id "
				+ "INNER JOIN buyer_info "
				+ "ON invoice.buyer_id = buyer_info.buyer_id ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
		
		while(results.next()){
			Invoice invoice = new Invoice();
			Timestamp invoiceDate = results.getTimestamp("invoice_date");
			int invoiceId = results.getInt("invoice_id");
			int buyerId = results.getInt("buyer_id");
			String buyerName = results.getString("buyer_id");
			int status = results.getInt("status");
			String saleType = results.getString("sale_type");
			List<Item>  items = getItemsByInvoiceId(invoiceId);
			
			invoice.setInvoiceId(invoiceId);
			invoice.setBuyerId(buyerId);
			invoice.setBuyerName(buyerName);
			invoice.setDate(invoiceDate);
			invoice.setItems(items);
			invoice.setSaleType(saleType);
			invoice.setStatus(status);
			
			invoices.add(invoice);
		}
					
		return invoices;
	}
	
	@Override
	public List<Invoice> getPastOrders() {
		
		List<Invoice> invoices = new ArrayList<Invoice>();
		String sqlSelectStatment = "SELECT invoice_id, invoice_date, buyer_id, buyer_name, status, sale_type FROM invoice "
				+ "INNER JOIN invoice_status "
				+ "ON invoice.invoice_status_id = invoice_status.invoice_status_id "
				+ "INNER JOIN sale_type"
				+ "ON invoice.sale_type_id = sale_type.sale_type_id "
				+ "INNER JOIN buyer_info "
				+ "ON invoice.buyer_id = buyer_info.buyer_id "
				+ "WHERE status = ? OR ? OR ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment, "Paid", "Delivered", "Archived");
		
		while(results.next()){
			Invoice invoice = new Invoice();
			Timestamp invoiceDate = results.getTimestamp("invoice_date");
			int invoiceId = results.getInt("invoice_id");
			int buyerId = results.getInt("buyer_id");
			String buyerName = results.getString("buyer_id");
			int status = results.getInt("status");
			String saleType = results.getString("sale_type");
			List<Item>  items = getItemsByInvoiceId(invoiceId);
			
			invoice.setInvoiceId(invoiceId);
			invoice.setBuyerId(buyerId);
			invoice.setBuyerName(buyerName);
			invoice.setDate(invoiceDate);
			invoice.setItems(items);
			invoice.setSaleType(saleType);
			invoice.setStatus(status);
			
			invoices.add(invoice);
		}
					
		return invoices;
		
	}

	@Override
	public List<Invoice> getPendingOrders() {
		
		List<Invoice> invoices = new ArrayList<Invoice>();
		String sqlSelectStatment = "SELECT invoice_id, invoice_date, buyer_id, buyer_name, status, sale_type FROM invoice "
				+ "INNER JOIN invoice_status "
				+ "ON invoice.invoice_status_id = invoice_status.invoice_status_id "
				+ "INNER JOIN sale_type"
				+ "ON invoice.sale_type_id = sale_type.sale_type_id "
				+ "INNER JOIN buyer_info "
				+ "ON invoice.buyer_id = buyer_info.buyer_id "
				+ "WHERE status = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment, "Pending");
		
		while(results.next()){
			Invoice invoice = new Invoice();
			Timestamp invoiceDate = results.getTimestamp("invoice_date");
			int invoiceId = results.getInt("invoice_id");
			int buyerId = results.getInt("buyer_id");
			String buyerName = results.getString("buyer_id");
			int status = results.getInt("status");
			String saleType = results.getString("sale_type");
			List<Item>  items = getItemsByInvoiceId(invoiceId);
			
			invoice.setInvoiceId(invoiceId);
			invoice.setBuyerId(buyerId);
			invoice.setBuyerName(buyerName);
			invoice.setDate(invoiceDate);
			invoice.setItems(items);
			invoice.setSaleType(saleType);
			invoice.setStatus(status);
			
			invoices.add(invoice);
		}
					
		return invoices;
		
	}
	
	
	
	private List<Item> getItemsByInvoiceId(int invoiceId) {
		List<Item> items = null;
		
		String sqlSelectStatemnt = "SELECT image_id, type, variety, harvest_quantity, price FROM invoice "
				+ "INNER JOIN invoice_item "
				+ "ON invoice.invoice_id = invoice_item.invoice_id "
				+ "INNER JOIN harvest_details "
				+ "ON invoice_item.harvest_details_id = item_harvest_details.harvest_detail_id "
				+ "INNER JOIN item"
				+ "ON item_harvest_details.item_id = item.item_id "
				+ "INNER JOIN item_price"
				+ "ON item_harvest_details.item_pirce_id = item_price.item_price_id "
				+ "WHERE invoice_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatemnt, invoiceId);
		
		while(results.next()){
			Item item = new Item();
			item.setHarvestQnty(results.getInt("harvest_quantity"));
			item.setImageId(results.getString("image_id"));
			item.setPrice((DollarAmount)results.getObject("price"));
			item.setType(results.getString("type"));
			item.setVariety(results.getString("variety"));
			
			items.add(item);
		}
		return items;
	}

	

}
