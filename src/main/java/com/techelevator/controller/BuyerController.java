package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes({"currentUser", "cart"})
public class BuyerController {

	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	public BuyerController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO, InvoiceDAO invoiceDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
		this.invoiceDAO = invoiceDAO;
	}
	
	@RequestMapping(path="/customer-views/order-completion", method=RequestMethod.GET)
	public String showOrderCompletionGet(HttpServletRequest request){
		
		return "order-completion";
	}

	@RequestMapping(path="/customer-views/order-completion", method=RequestMethod.POST)
	public String showOrderCompletionPost(HttpServletRequest request){
		
		return "redirect:/customer-views/order-completion";
	}
	
	@RequestMapping(path="/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventoryGet(HttpServletRequest request){
		
		List<Item> allAvailableCrops = itemDAO.allAvailableCropsList();
		
		request.setAttribute("availableCrops",  allAvailableCrops);
		
		return "customer-views/current-inventory";
	}

	
	@RequestMapping(path="/customer-views/account", method=RequestMethod.GET)
	public String showCustomerAccountGet(HttpServletRequest request){
		
		return "customer-views/account";
	}

	@RequestMapping(path="/customer-views/account", method=RequestMethod.POST)
	public String showCustomerAccountPost(HttpServletRequest request){
		
		return "redirect:/customer-views/account";
	}
}
