package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("CurrentUser")
public class FarmerController {

	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	public FarmerController(HarvestDAO harvestDAO, ItemDAO itemDAO, UserDAO userDAO, InvoiceDAO invoiceDAO){
		this.harvestDAO = harvestDAO;
		this.itemDAO = itemDAO;
		this.userDAO = userDAO;
		this.invoiceDAO = invoiceDAO;
	}
	
	@RequestMapping(path="/farmer-dashboard-views/dashboard", method=RequestMethod.GET)
	public String showDashboard(HttpServletRequest request){
		
		List<Invoice> allInvoices = invoiceDAO.getAllInvoices();
		List<Invoice> pastOrders =  invoiceDAO.getPastOrders();
		List<Invoice> pendingOrders =  invoiceDAO.getPendingOrders();
		List<Buyer> buyerList = userDAO.getAllBuyers();			
		List<Item> harvestItems = harvestDAO.getHarvestItemList();
		
		request.setAttribute("harvestItemsList", harvestItems);//TODO push
		request.setAttribute("buyerList", buyerList);	
		request.setAttribute("allInvoices", allInvoices);//TODO push 
		request.setAttribute("pastOrders", pastOrders); 
		request.setAttribute("pendingOrders", pendingOrders);
		
		return "farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method = RequestMethod.GET)
	public String addNewOrderItemToDatabaseGet(HttpServletRequest request) {
		
		List<String> distinctCropTypes = itemDAO.selectAllUniqueCropsByType();
		
		request.setAttribute("distinctCropTypes", distinctCropTypes);
		
		return "farmer-dashboard-views/enterInventory";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method = RequestMethod.POST)
	public String addNewOrderItemToDatabasePost(HttpServletRequest request) {
		
		
		//System.out.println(request.getParameter("harvestDetailsComments"));
	
		
		String imageId = request.getParameter("harvestImageId");
		String type = request.getParameter("type");
		String variety = request.getParameter("variety");
		int harvestQnty = Integer.parseInt(request.getParameter("harvestQuantity"));
		
			int temp = Math.round(100*Float.parseFloat(request.getParameter("price")));//TODO does this work?
		DollarAmount price = new DollarAmount(temp);
		//itemDAO.insertItem(imageId, type, variety, harvestQnty, price);//TODO fix insert in itemDAO
		
		List<Item> allCropsList = itemDAO.allCropsInDatabase();	
		request.setAttribute("allCropsList", allCropsList);
		
		return "redirect:/farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-pending-orders", method=RequestMethod.GET)
	public String viewPendingOrdersGet(HttpServletRequest request){
		
		List<Invoice> pendingOrders =  invoiceDAO.getPendingOrders();
		request.setAttribute("pendingOrders", pendingOrders);

		return "farmer-dashboard-views/view-pending-orders";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-pending-orders", method=RequestMethod.POST)
	public String viewPendingOrdersPost(HttpServletRequest request){
		
		List<Invoice> pendingOrders =  invoiceDAO.getPendingOrders();
		request.setAttribute("pendingOrders", pendingOrders);

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
		
		List<Invoice> pastOrders =  invoiceDAO.getPastOrders();
		request.setAttribute("pastOrders", pastOrders); 

		return "farmer-dashboard-views/view-past-orders";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/view-past-orders", method=RequestMethod.POST)
	public String viewPastOrdersPost(HttpServletRequest request){
		
		List<Invoice> pastOrders =  invoiceDAO.getPastOrders();
		request.setAttribute("pastOrders", pastOrders); 

		return "redirect:/farmer-dashboard-views/view-past-orders";
	}
	
	
}
