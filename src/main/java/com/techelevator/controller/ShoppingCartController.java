package com.techelevator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.CartItem;
import com.techelevator.model.HarvestDAO;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
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
	
	
//	@RequestMapping(path="/available-crops", method=RequestMethod.GET)
//	public String availableCropsGet(HttpServletRequest request) {
//		
//		List<Item> availableCrops = itemDAO.allAvailableCropsList();
//
//		request.setAttribute("availableCrops", availableCrops);
//		
//		
//		return "available-crops";
//	}
//	
//	@RequestMapping(path="/available-crops", method=RequestMethod.POST)
//	public String availableCropsPost(HttpServletRequest request) {
//		
//		List<Item> availableCrops = itemDAO.allAvailableCropsList();
//
//		request.setAttribute("availableCrops", availableCrops);
//		
//		
//		return "redirect:/available-crops";
//	}
	
	@RequestMapping(path="/shoppin-cart/crop-item-detials", method=RequestMethod.GET)
	public String cropDetailsGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			
			int cropId = Integer.parseInt(request.getParameter("itemId"));			
			request.setAttribute("cropItem", itemDAO.getCropById(cropId));
			return "shopping-cart/crop-item-details";
			
			
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	@RequestMapping(path="/customer-views/crop-item-detials", method=RequestMethod.POST)
	public String cropDetailsPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			
			int cropId = Integer.parseInt(request.getParameter("itemId"));			
			request.setAttribute("cropItem", itemDAO.getCropById(cropId));
			return "redirect:/current-inventory";
			
			
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
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
		Item crop = itemDAO.getCropById(productId);
		CartItem item = new CartItem();
		item.setCrop(crop);
		item.setQuantity(quantity);
		
		List<CartItem> items = (List<CartItem>) map.get("cart");
		if(items == null) {
			items = new ArrayList<CartItem>();
		}
		
		items.add(item);
		
		map.addAttribute("cart", items);
	
		return "redirect:/shopping-cart/checkout";
	}
	
}
