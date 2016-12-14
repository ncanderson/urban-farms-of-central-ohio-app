package com.techelevator.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.HarvestItem;
import com.techelevator.model.Invoice;
import com.techelevator.model.InvoiceDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

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


//---------------------------ADMIN ITEMS VIEWS---------------------------------------------------------
//---------------------------ADMIN ITEMS VIEWS---------------------------------------------------------

	
	@RequestMapping(path="admin/admin-item-view", method=RequestMethod.GET)
	public String adminItemViewGet(HttpServletRequest request){
			
		List<Item> activeCrops = itemDAO.getAllActiveCrops();
		request.setAttribute("activeCrops", activeCrops);
		
		return "admin/admin-item-view";
	}
	
	@RequestMapping(path="admin/admin-items-view-update", method=RequestMethod.POST)
	public String adminItemViewUpdatePost(HttpServletRequest request){
		
		Item item = new Item();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String start1 = request.getParameter("startDate1");
		String end1 = request.getParameter("endDate1");
		
		String start2 = request.getParameter("startDate2");
		String end2 = request.getParameter("endDate2");
		
		String start3 = request.getParameter("startDate3");
		String end3 = request.getParameter("endDate3");
		
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		item.setType(request.getParameter("itemType"));
		item.setVariety(request.getParameter("itemVariety"));
		item.setDescription(request.getParameter("itemDescription"));
		item.setActive(Boolean.valueOf(request.getParameter("itemIsActive")));
		
		if (!(start1.equals("") || start1 == null)) {
			item.setStartDate1(LocalDate.parse(start1, formatter));
		} 
		if (!(start2.equals("") || start2 == null)) {
			item.setStartDate2(LocalDate.parse(start2, formatter));
		} 
		if (!(start3.equals("") || start3 == null)) {
			item.setStartDate3(LocalDate.parse(start3, formatter));
		} 
		if (!(end1.equals("") || end1 == null)) {
			item.setEndDate1(LocalDate.parse(end1, formatter));
		}
		if (!(end2.equals("") || end2 == null)) {
			item.setEndDate2(LocalDate.parse(end2, formatter));
		}
		if (!(end3.equals("") || end3 == null)) {
			item.setEndDate3(LocalDate.parse(end3, formatter));
		}
		
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
	
	@RequestMapping(path="admin/admin-item-details-edit", method=RequestMethod.GET)
	public String adminEditItemDetails(HttpServletRequest request){
			
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		request.setAttribute("adminDetailItem", itemDAO.getAdminCropById(itemId));
		
		return "admin/admin-item-details-edit";
	}
	
	@RequestMapping(path="admin/admin-add-new-item", method=RequestMethod.GET)
	public String adminAddNewItem(HttpServletRequest request){
			
		
		return "admin/admin-item-new";
	}
	
//---------------------------ADMIN FARMER VIEWS---------------------------------------------------------

	@RequestMapping(path="/admin/admin-farmer-view-all", method=RequestMethod.GET)
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
	
//---------------------------ADMIN BUYER USERS VIEWS---------------------------------------------------------
//---------------------------ADMIN BUYER USERS VIEWS---------------------------------------------------------
	
	@RequestMapping(path="admin/admin-banners-all", method=RequestMethod.GET)
	public String adminAllBannerNotificationsView(HttpServletRequest request){
			
//		Return all banner notifications
		
		return "admin/admin-banners-all";
	}

	@RequestMapping(path="admin/admin-companies-all", method=RequestMethod.GET)
	public String adminAllCompaniesView(HttpServletRequest request){
			
//		List<User> allCompanies = userDAO.getAllCompanies();
//		request.setAttribute("allBuyers", allCompanies);
		
		return "admin/admin-companies-all";
	}
	
	@RequestMapping(path="admin/admin-buyer-users-all", method=RequestMethod.GET)
	public String adminAllBuyerUsersView(HttpServletRequest request){
			

		
		return "admin/admin-buyer-users-all";
	}
	
	@RequestMapping(path="admin/admin-all-buyer-users-all-insert", method=RequestMethod.POST)
	public String adminAllBuyerUsersViewInsert(HttpServletRequest request){
			
		User user = new User();
		
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setActive(Boolean.valueOf(request.getParameter("buyerUserIsActive")));
		user.setAdmin(Boolean.valueOf(request.getParameter("buyerUserIsAdmin")));
		String org = request.getParameter("buyerUserOrg");
		userDAO.addNewBuyerUser(user, org);
		
		return "redirect:/admin/admin-buyer-users-all";
	}
	
	@RequestMapping(path="admin/admin-add-new-buyer-user", method=RequestMethod.GET)
	public String adminAddNewBuyer(HttpServletRequest request){
			
		
		return "admin/admin-add-new-buyer-user";
	}
	
	
}
