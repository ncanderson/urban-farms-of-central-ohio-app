package com.techelevator.model;

import java.util.List;

import org.springframework.stereotype.Component;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	
	public List<Invoice> getPastOrders();
	
	public List<Invoice> getPendingOrders();
	
	public Invoice getInvoiceById(int invoiceId);
	
	public Invoice getPendingOrderForBuyer(int buyerId);
	
	public Invoice createNewInvoice(int userId, int buyerId);
	
	public void addItemToInvoice(Invoice invoice, HarvestItem item, int quantity);
	
	public List<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId);
}
