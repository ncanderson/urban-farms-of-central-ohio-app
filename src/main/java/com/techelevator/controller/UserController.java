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
	
	@RequestMapping(path="/dashboard",method=RequestMethod.POST)
	public String showDashboard(HttpServletRequest request){
		
		return "farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/admin-main-view",method=RequestMethod.POST)
	public String showAdminMainView(HttpServletRequest request){
		
		return "admin/admin-main-view";
	}
	
	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventory(HttpServletRequest request){
		
		return "customer-views/current-inventory";
	}
	
	
	

	
//	@RequestMapping(path="/current-inventory", method=RequestMethod.GET)
//	public String showCurrentInventory(HttpServletRequest request){
//		request.setAttribute("page", "inventory");
//		return "dashboard";
//	}
//	
//	@RequestMapping(path="/account", method=RequestMethod.GET)
//	public String showCustomerAccount(HttpServletRequest request){
//		request.setAttribute("page", "account");
//		return "dashboard";
//	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(path="/order-completion", method=RequestMethod.GET)
	public String showOrderCompletion(){
		
		return "order-completion";
	}

}
