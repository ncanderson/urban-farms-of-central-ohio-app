package com.techelevator.model;

import java.util.List;

import org.springframework.stereotype.Component;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	
	public List<Invoice> getPastOrders();
	
	public List<Invoice> getPendingOrders();
	
}
