package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.DollarAmount;
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
	
	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventoryGet(HttpServletRequest request){
		
		List<Item> allAvailableCrops = itemDAO.allAvailableCropsList();
		
		//request.setAttribute("availableCrops",  allAvailableCrops);
		
		//---------------------------------------------------------------
		List<Item> fauxItems = makeMockItems();//TODO this is fake delete it when ready
		request.setAttribute("availableCrops",  fauxItems);

		return "customer-views/current-inventory";
	}
	
	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.POST)
	public String showCurrentInventoryPost(HttpServletRequest request){
		//TODO submit order
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
	
	
	private List<Item> makeMockItems() {
		List<Item> itemList = new ArrayList<Item>();  
		
		Item tomato = new Item();
		tomato.setImageId("img/tomato.jpg");
		tomato.setType("Tomato");
		tomato.setVariety("Cherry");
		
		Item kale = new Item();
		kale.setImageId("img/kale.jpg");
		kale.setType("Kale");
		kale.setVariety("");
		
		Item cucumber = new Item();
		cucumber.setImageId("img/cucumber.jpg");
		cucumber.setType("Cucumber");
		cucumber.setVariety("Pickling");
		
		Item arugula = new Item();
		arugula.setImageId("img/arugula.jpg");
		arugula.setType("Arugula");
		arugula.setVariety("");
		
		Item lettuce = new Item();
		lettuce.setImageId("img/lettuce.jpg");
		lettuce.setType("Lettuce");
		lettuce.setVariety("Head");
		
		itemList.add(tomato);
		itemList.add(kale);
		itemList.add(cucumber);
		itemList.add(arugula);
		itemList.add(lettuce);
				
		return itemList;
	}
	
	
}
