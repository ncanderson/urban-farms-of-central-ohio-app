package com.techelevator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Buyer;
import com.techelevator.model.DollarAmount;
import com.techelevator.model.HarvestDAO;
import com.techelevator.model.Invoice;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

import gherkin.lexer.Pl;

@Controller
@SessionAttributes("currentUser")
public class UserController {
	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO; 
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	public UserController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO, InvoiceDAO invoiceDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
		this.invoiceDAO = invoiceDAO;
	}

//---------------------------ADMIN VIEWS---------------------------------------------------------
//---------------------------ADMIN VIEWS---------------------------------------------------------
	
	@RequestMapping(path="admin/admin-main-view", method=RequestMethod.GET)
	public String showAdminMainView(HttpServletRequest request){
			
		return "admin/admin-main-view";
	}
 
//---------------------------END ADMIN VIEWS------------------------------------------------------
//---------------------------END ADMIN VIEWS------------------------------------------------------	
	
//---------------------------FARMER VIEWS---------------------------------------------------------
//---------------------------FARMER VIEWS---------------------------------------------------------
	
	
//---------------------------END FARMER VIEWS-------------------------------------------------------------
//---------------------------END FARMER VIEWS-------------------------------------------------------------
	
//---------------------------CUSTOMER VIEWS---------------------------------------------------------------
//---------------------------CUSTOMER VIEWS---------------------------------------------------------------
	
	
 

//---------------------------END CUSTOMER VIEWS------------------------------------------------------------
//---------------------------END CUSTOMER VIEWS------------------------------------------------------------
	/**
	 * FOR TESTING ONLY UNTIL DB COMES ONLINE
	 * @return
	 */
	private List<Item> makeMockItems() {
		List<Item> itemList = new ArrayList<Item>();  
		
		Item tomato = new Item();
		tomato.setImageId("img/tomato.jpg");
		tomato.setType("Tomato");
		tomato.setVariety("Cherry");
		tomato.setHarvestQnty(20);
		tomato.setPrice(new DollarAmount(100));
		
		Item kale = new Item();
		kale.setImageId("img/kale.jpg");
		kale.setType("Kale");
		kale.setVariety("");
		kale.setHarvestQnty(10);
		kale.setPrice(new DollarAmount(600));
		
		Item cucumber = new Item();
		cucumber.setImageId("img/cucumber.jpg");
		cucumber.setType("Cucumber");
		cucumber.setVariety("Pickling");
		cucumber.setHarvestQnty(50);
		cucumber.setPrice(new DollarAmount(175));
		
		Item arugula = new Item();
		arugula.setImageId("img/arugula.jpg");
		arugula.setType("Arugula");
		arugula.setVariety("");
		arugula.setHarvestQnty(10);
		arugula.setPrice(new DollarAmount(200));
		
		Item lettuce = new Item();
		lettuce.setImageId("img/lettuce.jpg");
		lettuce.setType("Lettuce");
		lettuce.setVariety("Head");
		lettuce.setHarvestQnty(15);
		lettuce.setPrice(new DollarAmount(300));
		
		itemList.add(tomato);
		itemList.add(kale);
		itemList.add(cucumber);
		itemList.add(arugula);
		itemList.add(lettuce);
				
		return itemList;
	}
}
