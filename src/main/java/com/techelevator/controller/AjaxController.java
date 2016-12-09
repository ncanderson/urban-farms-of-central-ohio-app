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
	public List<Item> ajaxControllerForEnterInventoryView(@RequestParam String cropType) {
		List<Item> itemsByType = itemDAO.findAllCropsByType(cropType);
		return itemsByType;
	}
	
}
