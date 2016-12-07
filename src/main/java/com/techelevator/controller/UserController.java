package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("currentUser")
public class UserController {
	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	
	@Autowired
	public UserController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(path="/farmer-dashboard-views/dashboard", method=RequestMethod.GET)
	public String showDashboard(HttpServletRequest request){

		
		return "farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="admin/admin-main-view",method=RequestMethod.GET)
	public String showAdminMainView(HttpServletRequest request){
		
		
		return "farmer-dashboard-views/dashboard";
	}

	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventory(HttpServletRequest request){
		
		return "customer-views/current-inventory";
	}
	

	@RequestMapping(path="/enterInventory", method = RequestMethod.POST)
	public String addNewOrderItemToDatabase() {
		return "redirect:/farmer-dashboard-views/enterInventory";
	}
	
	@RequestMapping(path="/order-completion", method=RequestMethod.GET)
	public String showOrderCompletion(HttpServletRequest request){
		
		return "order-completion";
	}

}
