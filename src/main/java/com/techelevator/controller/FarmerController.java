package com.techelevator.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("currentUser")
@Transactional

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
		List<HarvestItem> harvestItems = harvestDAO.getHarvestItemList();
		 
		request.setAttribute("allInvoices", allInvoices); 
		request.setAttribute("pastOrders", pastOrders); 
		request.setAttribute("pendingOrders", pendingOrders);
		request.setAttribute("buyerList", buyerList);	
		request.setAttribute("harvestItemsList", harvestItems);
		
		return "farmer-dashboard-views/dashboard";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method = RequestMethod.GET)
	public String addNewOrderItemToDatabaseGet(HttpServletRequest request) {
		
		List<String> distinctCropTypes = itemDAO.selectAllUniqueCropsByType();
		
		request.setAttribute("distinctCropTypes", distinctCropTypes);
		request.setAttribute("firstCropType", distinctCropTypes.get(0));
		
		return "farmer-dashboard-views/enterInventory";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/enterInventory", method=RequestMethod.POST)
	public String addNewOrderItemToDatabasePost(HttpServletRequest request) {
		
		Item selectedItem = itemDAO.getCropByTypeAndVariety(request.getParameter("type"), request.getParameter("variety"));
		HarvestItem itemToSave = new HarvestItem();
		itemToSave.setItemId(selectedItem.getItemId());
		
//		if (!request.getParameter("harvestImageId").isEmpty()) {
//			itemToSave.setHarvestImageId(GET IMAGE ID FROM THE SELECTED ITEM);	//CHRISTIAN LOOK AT THIS want to load default image.	
//		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String dateInput = request.getParameter("harvestEndDate");
		
		itemToSave.setHarvestQnty(Integer.parseInt(request.getParameter("harvestQuantity")));
		itemToSave.setAverageSize(request.getParameter("averageSizeOfItem"));
		itemToSave.setAvailability(request.getParameter("harvestAvailability"));
		itemToSave.setComments(request.getParameter("harvestDetailsComments"));
		itemToSave.setFarmerEnteredPickComments(request.getParameter("farmerEnteredPickComments"));
		
		if (!(dateInput.equals("") || dateInput == null)) {
			itemToSave.setEndDate(LocalDate.parse(dateInput, formatter));
		} 
		
		String priceString = request.getParameter("pricePerPound").replaceAll("\\$", "");
		double convertedPrice = Double.parseDouble(priceString);
		itemToSave.setPrice(new BigDecimal(convertedPrice));

		harvestDAO.addHarvestItem(itemToSave);
		
		List<HarvestItem> allHarvestItemsList = harvestDAO.getAllHarvestItems();	
		request.setAttribute("harvestItemsList", allHarvestItemsList);

		return "redirect:/farmer-dashboard-views/dashboard";
	}
	
	
	
	@RequestMapping(path="/farmer-dashboard-views/editInventoryItem", method=RequestMethod.GET)
	public String editItemDetails(HttpServletRequest request) {
		int harvestCropId = Integer.parseInt(request.getParameter("harvestItemId"));
		
		HarvestItem detailCrop = harvestDAO.getHarvestItemById(harvestCropId);
		List<String> varietiesOfSelectedType = itemDAO.selectAllVarietiesByCropType(detailCrop.getItemType());
		
		List<String> distinctCropTypes = itemDAO.selectAllUniqueCropsByType();
		
		request.setAttribute("detailCrop", detailCrop);
		request.setAttribute("distinctCropTypes", distinctCropTypes);
		request.setAttribute("varietiesOfSelectedType", varietiesOfSelectedType);
		
		return "farmer-dashboard-views/editInventoryItem";
	}
	
	@RequestMapping(path="/farmer-dashboard-views/editInventoryItem", method=RequestMethod.POST)
	public String postEditedItemDetails(HttpServletRequest request) {

//		Implement and update SQL query with the new information from the update form
		
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
