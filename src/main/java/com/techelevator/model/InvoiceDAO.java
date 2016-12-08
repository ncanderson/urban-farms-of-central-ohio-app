package com.techelevator.model;

import java.util.List;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	
	public List<Invoice> getPastOrders();
	
	public List<Invoice> getPendingOrders();
}
