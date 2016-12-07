package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.DollarAmount;
import com.techelevator.model.HarvestDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;



@Controller 
public class HomeController {
	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	
	@Autowired
	public HomeController(UserDAO userDAO, HarvestDAO harvestDAO){
		this.userDAO = userDAO;
		this.harvestDAO = harvestDAO;
	}
	
	@RequestMapping(path={"/", "/welcome"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request){
		
//		List<Item> itemList = harvestDAO.getHarvestItemList();
		
		List<Item> itemList = makeMockItems();
		request.setAttribute("itemList", itemList);
		
		return "anonymous-item-view";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm(HttpServletRequest reqeust){
		
		return "login";
	}
	
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
