package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.ItemDAO;

@Controller
public class CustomerController {
	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	
	@Autowired
	public CustomerController(HarvestDAO harvestDAO, ItemDAO itemDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
	}
	
	@RequestMapping(path="/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventory(){
		
		return null;
	}

}
