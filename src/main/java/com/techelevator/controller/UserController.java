package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.DollarAmount;
import com.techelevator.model.HarvestDAO;
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
//---------------------------ADMIN VIEWS---------------------------------------------------------
	
	@RequestMapping(path="admin/admin-main-view",method=RequestMethod.GET)
	public String showAdminMainView(HttpServletRequest request){
			
		return "admin/admin-main-view";
	}

//---------------------------END ADMIN VIEWS------------------------------------------------------
//---------------------------END ADMIN VIEWS------------------------------------------------------	
	
//---------------------------FARMER VIEWS---------------------------------------------------------
//---------------------------FARMER VIEWS---------------------------------------------------------
	
	@RequestMapping(path="/farmer-dashboard-views/dashboard", method=RequestMethod.GET)
	public String showDashboard(HttpServletRequest request){
		
		List<Invoice> allInvoices = invoiceDAO.getAllInvoices();
		List<Invoice> pastOrders =  invoiceDAO.getPastOrders();
		List<Invoice> pendingOrders =  invoiceDAO.getPendingOrders();
		List<User> customerList = userDAO.getAllCustomers();			
		List<Item> harvestItems = harvestDAO.getHarvestItemList();
		
		request.setAttribute("harvestItemsList", harvestItems);
		request.setAttribute("customerList", customerList);
		request.setAttribute("pastOrders", pastOrders);
		request.setAttribute("pendingOrders", pendingOrders);
		
		return "farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method = RequestMethod.GET)
	public String addNewOrderItemToDatabaseGet(HttpServletRequest request) {
		
		
		return "farmer-dashboard-views/enterInventory";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method = RequestMethod.POST)
	public String addNewOrderItemToDatabasePost(HttpServletRequest request) {
		
		String imageId = (String) request.getAttribute("imageId");
		String type = (String) request.getAttribute("type");
		String variety = (String) request.getAttribute("variety");
		int harvestQnty = Integer.parseInt((String)request.getAttribute("harvestQnty"));
			int temp = Math.round(100*Float.parseFloat(request.getParameter("price")));
		DollarAmount price = new DollarAmount(temp);//TODO dallor amount stuff ??
		
		itemDAO.insertItem(imageId, type, variety, harvestQnty, price);//TODO fix insert in itemDAO
		return "redirect:/farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-pending-orders", method=RequestMethod.GET)
	public String viewPendingOrdersGet(HttpServletRequest request){
		
		return "farmer-dashboard-views/view-pending-orders";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-pending-orders", method=RequestMethod.POST)
	public String viewPendingOrdersPost(HttpServletRequest request){
		
		return "redirect:/farmer-dashboard-views/view-pending-orders";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/update-user-info", method=RequestMethod.GET)
	public String updateUserInfoGet(HttpServletRequest request){
		
		return "farmer-dashboard-views/update-user-info";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/update-user-info", method=RequestMethod.POST)
	public String updateUserInfoPost(HttpServletRequest request){
		
		return "redirect:/farmer-dashboard-views/update-user-info";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-past-orders", method=RequestMethod.GET)
	public String viewPastOrdersGet(HttpServletRequest request){
		
		return "farmer-dashboard-views/view-past-orders";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-past-orders", method=RequestMethod.POST)
	public String viewPastOrdersPost(HttpServletRequest request){
		
		return "redirect:/farmer-dashboard-views/view-past-orders";
	}
//---------------------------END FARMER VIEWS-------------------------------------------------------------
//---------------------------END FARMER VIEWS-------------------------------------------------------------
	
//---------------------------CUSTOMER VIEWS---------------------------------------------------------------
//---------------------------CUSTOMER VIEWS---------------------------------------------------------------
	
	
	@RequestMapping(path="/customer-views/order-completion", method=RequestMethod.GET)
	public String showOrderCompletionGet(HttpServletRequest request){
		
		return "order-completion";
	}

	@RequestMapping(path="/customer-views/order-completion", method=RequestMethod.POST)
	public String showOrderCompletionPost(HttpServletRequest request){
		
		return "redirect:/customer-views/order-completion";
	}
	
	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.GET)
	public String showCurrentInventoryGet(HttpServletRequest request){
		
		return "customer-views/current-inventory";
	}

	@RequestMapping(path="/customer-views/current-inventory", method=RequestMethod.POST)
	public String showCurrentInventoryPost(HttpServletRequest request){
		
		return "redirect:/customer-views/current-inventory";
	}
	
	@RequestMapping(path="/customer-views/account", method=RequestMethod.GET)
	public String showCustomerAccountGet(HttpServletRequest request){
		
		return "customer-views/account";
	}

	@RequestMapping(path="/customer-views/account", method=RequestMethod.POST)
	public String showCustomerAccountPost(HttpServletRequest request){
		
		return "redirect:/customer-views/account";
	}
//---------------------------END CUSTOMER VIEWS------------------------------------------------------------
//---------------------------END CUSTOMER VIEWS------------------------------------------------------------
	/**
	 * FOR TESTING ONLY UNTIL DB COMES ONLINE
	 * @return
	 */
	private List<Item> makeMockItems() {
		List<Item> itemList = new ArrayList<Item>();  
		
		Item tomato = new Item();
		tomato.setImageId("img/tomato.jpg");
		tomato.setType("Tomato");
		tomato.setVariety("Cherry");
		tomato.setHarvestQnty(20);
		tomato.setPrice(new DollarAmount(100));
		
		Item kale = new Item();
		kale.setImageId("img/kale.jpg");
		kale.setType("Kale");
		kale.setVariety("");
		kale.setHarvestQnty(10);
		kale.setPrice(new DollarAmount(600));
		
		Item cucumber = new Item();
		cucumber.setImageId("img/cucumber.jpg");
		cucumber.setType("Cucumber");
		cucumber.setVariety("Pickling");
		cucumber.setHarvestQnty(50);
		cucumber.setPrice(new DollarAmount(175));
		
		Item arugula = new Item();
		arugula.setImageId("img/arugula.jpg");
		arugula.setType("Arugula");
		arugula.setVariety("");
		arugula.setHarvestQnty(10);
		arugula.setPrice(new DollarAmount(200));
		
		Item lettuce = new Item();
		lettuce.setImageId("img/lettuce.jpg");
		lettuce.setType("Lettuce");
		lettuce.setVariety("Head");
		lettuce.setHarvestQnty(15);
		lettuce.setPrice(new DollarAmount(300));
		
		itemList.add(tomato);
		itemList.add(kale);
		itemList.add(cucumber);
		itemList.add(arugula);
		itemList.add(lettuce);
				
		return itemList;
	}
}
