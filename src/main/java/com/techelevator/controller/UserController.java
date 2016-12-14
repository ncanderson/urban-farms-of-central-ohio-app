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
import com.techelevator.model.HarvestItem;
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
	
	@RequestMapping(path="admin/admin-main-view", method=RequestMethod.GET)
	public String adminMainView(HttpServletRequest request){
			
		return "admin/admin-main-view";
	}
	
	@RequestMapping(path="admin/admin-item-view", method=RequestMethod.GET)
	public String adminItemViewGet(HttpServletRequest request){
			
		List<Item> activeCrops = itemDAO.getAllActiveCrops();
		request.setAttribute("activeCrops", activeCrops);
		
		return "admin/admin-item-view";
	}
	
	@RequestMapping(path="admin/admin-items-view-update", method=RequestMethod.POST)
	public String adminItemViewUpdatePost(HttpServletRequest request){
		
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
		return "redirect:/admin/admin-item-view";
	}
	
	@RequestMapping(path="admin/admin-items-view-insert", method=RequestMethod.POST)
	public String adminItemViewInsertPost(HttpServletRequest request){
		
		Item item = new Item();
		
		item.setType(request.getParameter("itemType"));
		item.setVariety(request.getParameter("itemVariety"));
		item.setDescription(request.getParameter("itemDescription"));
		item.setActive(Boolean.valueOf(request.getParameter("itemIsActive")));
		//TODO get season start end dates
		itemDAO.addNewItem(item); 
		
		List<Item> activeCrops = itemDAO.getAllActiveCrops();
		request.setAttribute("activeCrops", activeCrops);
	
		System.out.println(item.getDescription());
		
		return "redirect:/admin/admin-item-view";
	}
	
	@RequestMapping(path="admin/admin-edit-item-details", method=RequestMethod.GET)
	public String adminEditItemDetails(HttpServletRequest request){
			
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		request.setAttribute("item", itemDAO.getAdminCropById(itemId));
		
		return "admin/admin-item-details-edit";
	}
	
	@RequestMapping(path="admin/admin-add-new-item", method=RequestMethod.GET)
	public String adminAddNewItem(HttpServletRequest request){
			
		
		return "admin/admin-item-new";
	}
	
	@RequestMapping(path="/admin/admin-all-farmers-view", method=RequestMethod.GET)
	public String adminAddUserViewGet(HttpServletRequest request){
			
		List<User> allFarmers = userDAO.getAllFarmers();
		request.setAttribute("allFarmers", allFarmers);
		
		return "admin/admin-farmer-view-all";
	}
	
	@RequestMapping(path="/admin/admin-all-farmers-view-update", method=RequestMethod.POST)
	public String adminAddUserViewPostUpdate(HttpServletRequest request){
			
		//TODO updated edited farmer
		User user = new User();
		int userId = Integer.parseInt(request.getParameter("userID"));
   		
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setActive(Boolean.valueOf(request.getParameter("farmerIsActive")));
		
		userDAO.updateFarmer(user, userId);
		
		List<User> allFarmers = userDAO.getAllFarmers();
		request.setAttribute("allFarmers", allFarmers);
		
		return "redirect:/admin/admin-farmer-view-all";
	}
	
	@RequestMapping(path="/admin/admin-all-farmers-view-insert", method=RequestMethod.POST)
	public String adminAddUserViewPostInsert(HttpServletRequest request){
			
		//TODO updated edited farmer
		User user = new User();
		
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setActive(Boolean.valueOf(request.getParameter("farmerIsActive")));
		user.setAdmin(Boolean.valueOf(request.getParameter("farmerIsAdmin")));
		
		userDAO.addNewFarmer(user);
		
		List<User> allFarmers = userDAO.getAllFarmers();
		request.setAttribute("allFarmers", allFarmers);
		
		return "redirect:/admin/admin/admin-farmer-view-all";
	}
	
	@RequestMapping(path="/admin/admin-edit-farmer-view", method=RequestMethod.GET)
	public String adminEditFarmer(HttpServletRequest request){
			
		int farmerId = Integer.parseInt(request.getParameter("userID"));
		
		User farmer = userDAO.getUserById(farmerId);
		
		request.setAttribute("farmer", farmer);
				
		return "admin/admin-farmer-edit";
	}
	
	@RequestMapping(path="admin/admin-add-new-farmer", method=RequestMethod.GET)
	public String adminAddNewFarmer(HttpServletRequest request){
			

		
		return "admin/admin-farmer-new";
	}
	
	
	@RequestMapping(path="admin/admin-all-buyer-users-view", method=RequestMethod.GET)
	public String adminAllBuyersView(HttpServletRequest request){
			
		List<User> allBuyerUsers = userDAO.getAllBuyerUsers();
		request.setAttribute("allBuyers", allBuyerUsers);
		
		return "admin/admin-buyer-users-all";
	}
}
