package com.techelevator.controller;

import java.math.BigDecimal;
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
	private HarvestDAO harvestDAO;
	
	@Autowired
	public AjaxController(ItemDAO itemDAO, HarvestDAO harvestDAO) {
		this.itemDAO = itemDAO;
		this.harvestDAO = harvestDAO;
	}
	
	@RequestMapping(path="/farmer-dashboard-views/cropPicker", method = RequestMethod.GET)
	public List<Item> ajaxControllerForEnterInventoryView(@RequestParam String cropType) {
		List<Item> itemsByType = itemDAO.findAllCropsByType(cropType);
		return itemsByType;
	}
	
	@RequestMapping(path="/farmer-dashboard-views/noVarietyPriceGetter", method=RequestMethod.GET)
	public BigDecimal ajaxControllerForRecentPriceWithoutVariety(@RequestParam String cropType) {
		
		Item typeNoVariety = itemDAO.getCropByTypeAndVariety(cropType, "");
		BigDecimal itemPrice = harvestDAO.getCurrentItemPrice(typeNoVariety.getItemId());
		if (itemPrice == null) {
			return BigDecimal.valueOf(0.0);
		}
		else {
			return itemPrice;
		}
	}
	
	@RequestMapping(path="/farmer-dashboard-views/priceGetter", method=RequestMethod.GET)
	public BigDecimal ajaxControllerForGetMostRecentPrice(@RequestParam String cropType,
														  @RequestParam String cropVariety) {
		
		Item itemSought = itemDAO.getCropByTypeAndVariety(cropType, cropVariety);
		BigDecimal itemPrice = harvestDAO.getCurrentItemPrice(itemSought.getItemId());
		return itemPrice;
	}
	
}

