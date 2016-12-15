package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceItem {
	
	private int invoiceItemId;
	private int invoiceId;
	private int invoiceQnty;
	private int harvestDetailsId;
	private BigDecimal updatedItemPrice; // Generated from previous data in the controller, based on "sale type"
	private int userId; // Login userId
	private int invoiceItemStatusId; // From invoice_status table 
	private BigDecimal invoiceOverridePrice; // Farmer admin can override specific items at the invoice level
	private Date dateAddedToInvoice; // Generated auto when they add to cart
	
	public int getInvoiceItemId() {
		return invoiceItemId;
	}
	public void setInvoiceItemId(int invoiceItemId) {
		this.invoiceItemId = invoiceItemId;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getInvoiceQnty() {
		return invoiceQnty;
	}
	public void setInvoiceQnty(int invoiceQnty) {
		this.invoiceQnty = invoiceQnty;
	}
	public int getHarvestDetailsId() {
		return harvestDetailsId;
	}
	public void setHarvestDetailsId(int harvestDetailsId) {
		this.harvestDetailsId = harvestDetailsId;
	}
	public BigDecimal getUpdatedItemPrice() {
		return updatedItemPrice;
	}
	public void setUpdatedItemPrice(BigDecimal updatedItemPrice) {
		this.updatedItemPrice = updatedItemPrice;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getInvoiceItemStatusId() {
		return invoiceItemStatusId;
	}
	public void setInvoiceItemStatusId(int invoiceItemStatusId) {
		this.invoiceItemStatusId = invoiceItemStatusId;
	}
	public BigDecimal getInvoiceOverridePrice() {
		return invoiceOverridePrice;
	}
	public void setInvoiceOverridePrice(BigDecimal invoiceOverridePrice) {
		this.invoiceOverridePrice = invoiceOverridePrice;
	}
	public Date getDateAddedToInvoice() {
		return dateAddedToInvoice;
	}
	public void setDateAddedToInvoice(Date dateAddedToInvoice) {
		this.dateAddedToInvoice = dateAddedToInvoice;
	}
//	public BigDecimal getInvoiceItemPrice(){
//		 
//		return harvestDAO.getCurrentItemPrice(this.harvestDetailsId);
//	}

}
