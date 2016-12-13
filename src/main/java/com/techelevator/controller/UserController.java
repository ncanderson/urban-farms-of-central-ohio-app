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
	public String adminMainView(HttpServletRequest request){
			
		return "admin/admin-main-view";
	}
	
	@RequestMapping(path="admin/admin-items-view", method=RequestMethod.GET)
	public String adminItemViewGet(HttpServletRequest request){
			
		List<Item> activeCrops = itemDAO.getAllActiveCrops();
		request.setAttribute("activeCrops", activeCrops);
		
		return "admin/admin-items-view";
	}
	
	@RequestMapping(path="admin/admin-items-view", method=RequestMethod.POST)
	public String adminItemViewPost(HttpServletRequest request){
		
		Item item = new Item();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		item.setType(request.getParameter("itemType"));
		item.setVariety(request.getParameter("itemVariety"));
		item.setDescription(request.getParameter("itemDescription"));
		item.setActive(Boolean.valueOf(request.getParameter("itemIsActive")));
		//TODO get season start end dates
		
		List<Item> activeCrops = itemDAO.getAllActiveCrops();
		request.setAttribute("activeCrops", activeCrops);
	
		
		itemDAO.updateItem(item, itemId); 
		return "admin/admin-items-view";
	}
	
	@RequestMapping(path="admin/admin-edit-item-details", method=RequestMethod.GET)
	public String adminEditItemDetails(HttpServletRequest request){
			
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		request.setAttribute("item", itemDAO.getAdminCropById(itemId));

		
		return "admin/admin-edit-item-details";
	}
	@RequestMapping(path="/admin/admin-all-farmers-view", method=RequestMethod.GET)
	public String adminAddUserView(HttpServletRequest request){
			
		List<User> allFarmers = userDAO.getAllFarmers();
		request.setAttribute("allFarmers", allFarmers);
		
		return "admin/admin-all-farmers-view";
	}

}
