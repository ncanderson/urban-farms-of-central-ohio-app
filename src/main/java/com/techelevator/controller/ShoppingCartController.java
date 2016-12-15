package com.techelevator.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.BuyerOrganization;
import com.techelevator.model.BuyerOrganizationDAO;
import com.techelevator.model.HarvestDAO;
import com.techelevator.model.HarvestItem;
import com.techelevator.model.Invoice;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.InvoiceItem;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;


@Controller 
@SessionAttributes({"currentUser", "cart"})
public class ShoppingCartController {

	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	private InvoiceDAO invoiceDAO;
	private BuyerOrganizationDAO buyerOrganizationDAO;
	
	@Autowired
	public ShoppingCartController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO, InvoiceDAO invoiceDAO, BuyerOrganizationDAO buyerOrganizationDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
		this.invoiceDAO = invoiceDAO;
		this.buyerOrganizationDAO = buyerOrganizationDAO;
	}
	
	@RequestMapping(path="/customer-views/shopping-cart", method=RequestMethod.GET)
	public String viewShoppingCart(@RequestParam int invoiceId, 
								   HttpServletRequest request,
								   ModelMap model) {

		Invoice invoice = invoiceDAO.getInvoiceById(invoiceId);
		List<InvoiceItem> invoiceItems = invoiceDAO.getInvoiceItemsByInvoiceId(invoice.getInvoiceId());
		invoice.setInvoiceItems(invoiceItems);
		
		List<HarvestItem> lineItemHarvestDetailsItem = new ArrayList<HarvestItem>();
		for (InvoiceItem lineItem : invoiceItems) {
			HarvestItem detailOfLineItem = harvestDAO.getHarvestItemById(lineItem.getHarvestDetailsId());
			lineItemHarvestDetailsItem.add(detailOfLineItem);
		}
		
		User user = (User)model.get("currentUser");
		BuyerOrganization buyerOrganization = buyerOrganizationDAO.getBuyerOrganizationById(invoice.getBuyerId());
		
		BigDecimal total = invoice.getInvoiceTotal();
		
		request.setAttribute("total", total);
		request.setAttribute("invoice", invoice); // Object
		request.setAttribute("user", user); // Object
		request.setAttribute("buyerOrganization", buyerOrganization); // Object
		request.setAttribute("invoiceItems", invoiceItems); // List 
		request.setAttribute("harvestDetailItems", lineItemHarvestDetailsItem); // List
		
		
		return "customer-views/shopping-cart";
	}
	
	@RequestMapping(path="/customer-views/shopping-cart", method=RequestMethod.POST)
	public String addingInvoiceToShoppingCart(@RequestParam int harvestQuantityToBuy,
											  @RequestParam int harvestItemToBuy,
											  HttpServletRequest request,
											  ModelMap model) {
		
		User user = (User)model.get("currentUser");
		
		int buyerId = userDAO.getBuyerByUserId(user.getUserId());

		Invoice invoice = invoiceDAO.getPendingOrderForBuyer(buyerId);
	

		if(invoice == null) {
			invoice = invoiceDAO.createNewInvoice(user.getUserId(), buyerId);	
		}
		
		
		HarvestItem item = harvestDAO.getHarvestItemById(harvestItemToBuy);
		invoiceDAO.addItemToInvoice(invoice, item, harvestQuantityToBuy);
		List<InvoiceItem> invoiceItems = invoiceDAO.getInvoiceItemsByInvoiceId(invoice.getInvoiceId());
		
		request.setAttribute("invoice", invoice);
		request.setAttribute("itemList", invoiceItems);
		
		return "redirect:/customer-views/shopping-cart?invoiceId=" + invoice.getInvoiceId();
	} 
	
	@RequestMapping(path="/customer-views/checkout", method=RequestMethod.GET)
	public String checkoutGet(HttpServletRequest request){ 
	
		
		return "customer-views/checkout";
	}
	
	
	@RequestMapping(path="/customer-views/checkout", method=RequestMethod.POST)
	public String checkoutPost(@RequestParam int productId, 
							   @RequestParam int quantity, 
							   ModelMap map) {
		
		//TODO change method
//		Item crop = itemDAO.getCropById(productId);
//		CartItem item = new CartItem();
//		item.setCrop(crop);
//		item.setQuantity(quantity);
//		
//		List<CartItem> items = (List<CartItem>) map.get("cart");
//		if(items == null) {
//			items = new ArrayList<CartItem>();
//		}
//		
//		items.add(item);
//		
//		map.addAttribute("cart", items);
//	
		return "redirect:/customer-views/order-completion";
	}
	
	@RequestMapping(path="/customer-views/order-completion", method=RequestMethod.GET)
	public String orderCompletion() {
		
		return "customer-views/order-completion";
	}
	
	
	
}
