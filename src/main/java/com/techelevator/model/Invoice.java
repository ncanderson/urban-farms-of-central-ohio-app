package com.techelevator.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

public class Invoice {

	private Timestamp date;
	private String buyerName;
	private int buyerId;
	private int invoiceId;
	private String saleType;
	private String status;
	private List<InvoiceItem> invoiceItems;
	private int userId;
	private HarvestDAO harvestDAO;
	
	public Invoice(){
		
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getInvoiceTotal() {
		BigDecimal total = new BigDecimal(0);
		
		System.out.println("invoice test");
		
		for (InvoiceItem item: this.invoiceItems) {
			System.out.println("inside for loop");
			BigDecimal harvestDetailsPrice = harvestDAO.getCurrentItemPrice(item.getHarvestDetailsId());
			
			total = total.add(harvestDetailsPrice);
		}

		return total.doubleValue();

	}
	
	
	
}
