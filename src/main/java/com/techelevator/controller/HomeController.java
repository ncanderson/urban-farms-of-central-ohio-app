package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.HarvestItem;
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
	
	@RequestMapping(path="/anonymous-detail-view", method=RequestMethod.GET)
	public String getAnonymousDetailView(HttpServletRequest request) {
		int harvestCropId = Integer.parseInt(request.getParameter("itemId"));
		
		HarvestItem detailCrop = harvestDAO.getHarvestItemById(harvestCropId);
		
		request.setAttribute("detailCrop", detailCrop);
		
		return "anonymous-detail-view";
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
		tomato.setItemId(0);
		tomato.setImageId("img/tomato.jpg");
		tomato.setType("Tomato");
		tomato.setVariety("Cherry");
		
		Item kale = new Item();
		kale.setItemId(1);
		kale.setImageId("img/kale.jpg");
		kale.setType("Kale");
		kale.setVariety("");
		
		Item cucumber = new Item();
		cucumber.setItemId(2);
		cucumber.setImageId("img/cucumber.jpg");
		cucumber.setType("Cucumber");
		cucumber.setVariety("Pickling");
		
		Item arugula = new Item();
		arugula.setItemId(3);
		arugula.setImageId("img/arugula.jpg");
		arugula.setType("Arugula");
		arugula.setVariety("");
		
		Item lettuce = new Item();
		lettuce.setItemId(4);
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
