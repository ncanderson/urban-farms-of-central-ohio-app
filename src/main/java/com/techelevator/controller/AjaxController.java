package com.techelevator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.DollarAmount;
import com.techelevator.model.HarvestDAO;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;

@RestController
public class AjaxController {

	private ItemDAO itemDAO;
	
	@Autowired
	public AjaxController(ItemDAO itemDAO){
		this.itemDAO = itemDAO;
	}
	
	@RequestMapping(path="/farmer-dashboard-views/cropPicker", method = RequestMethod.GET)
	public Map<String, List<Item>> ajaxControllerForEnterInventoryView(@RequestParam String cropType) {
		
		Map<String, List<Item>> typeAndVarietyMap = new HashMap<String, List<Item>>();
		List<Item> itemsByType = itemDAO.findAllCropsByType(cropType);
		typeAndVarietyMap.put("crop-type", itemsByType);
		
//		Item tomato = new Item();
//		tomato.setImageId("img/tomato.jpg");
//		tomato.setType("Tomato");
//		tomato.setVariety("Cherry");
//		tomato.setHarvestQnty(20);
//		tomato.setPrice(new DollarAmount(100));
//		
//		Item kale = new Item();
//		kale.setImageId("img/kale.jpg");
//		kale.setType("Kale");
//		kale.setVariety("");
//		kale.setHarvestQnty(10);
//		kale.setPrice(new DollarAmount(600));
//		
//		List<Item> testList = new ArrayList<Item>();
//		testList.add(tomato);
//		testList.add(kale);
//		
//		typeAndVarietyMap.put("crops", testList);
		
		return typeAndVarietyMap;
	}
	
}
