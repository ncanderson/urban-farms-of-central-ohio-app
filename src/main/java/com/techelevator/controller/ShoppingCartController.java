package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.HarvestItem;
import com.techelevator.model.Invoice;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.InvoiceItem;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;


@Controller 
@SessionAttributes({"currentUser", "cart"})//TODO does "cart" need to be carried through form beginning?
public class ShoppingCartController {

	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	public ShoppingCartController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO, InvoiceDAO invoiceDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
		this.invoiceDAO = invoiceDAO;
	}
	
	@RequestMapping(path="/customer-views/shopping-cart", method=RequestMethod.GET)
	public String viewShoppingCart(@RequestParam int invoiceId, HttpServletRequest request) {

		Invoice invoice = invoiceDAO.getInvoiceById(invoiceId);
		List<InvoiceItem> items = invoiceDAO.getInvoiceItemsByInvoiceId(invoice.getInvoiceId());

		request.setAttribute("invoice", invoice);
		request.setAttribute("itemList", items);
		
		return "customer-views/shopping-cart";
	}
	
	@RequestMapping(path="/customer-views/shopping-cart", method=RequestMethod.POST)
	public String addingInvoiceToShoppingCart(@RequestParam int harvestQuantityToBuy,
											  @RequestParam int harvestItemToBuy,
											  ModelMap model) {
		
		User user = (User)model.get("currentUser");
		int buyerId = userDAO.getBuyerByUserId(user.getUserId());
		Invoice invoice = invoiceDAO.getPendingOrderForBuyer(buyerId);
		
		if(invoice == null) {
			invoice = invoiceDAO.createNewInvoice(user.getUserId(), buyerId);	
		}
		
		System.out.println("InvoiceId: " + invoice.getInvoiceId());
		
		HarvestItem item = harvestDAO.getHarvestItemById(harvestItemToBuy);
		invoiceDAO.addItemToInvoice(invoice, item, harvestQuantityToBuy);
		
		return "redirect:/customer-views/shopping-cart?invoiceId=" + invoice.getInvoiceId();
	}
	
	@RequestMapping(path="/customer-views/shopping-cart/checkout", method=RequestMethod.GET)
	public String checkoutGet(HttpServletRequest request){ 
	
		
		return "shopping-cart/checkout";
	}
	
	
	@RequestMapping(path="/customer-views/shopping-cart/checkout", method=RequestMethod.POST)
	public String checkoutPost(@RequestParam int productId, 
									@RequestParam int quantity, 
									ModelMap map){
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
		return "redirect:/shopping-cart/checkout";
	}
	
	
	
}
