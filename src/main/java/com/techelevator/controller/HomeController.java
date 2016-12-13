package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.HarvestItem;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;

@Controller 
public class HomeController {
	
	private HarvestDAO harvestDAO;
	private UserDAO userDAO;
	
	@Autowired
	public HomeController(UserDAO userDAO, HarvestDAO harvestDAO){
		this.userDAO = userDAO;
		this.harvestDAO = harvestDAO;
	}
	
	@RequestMapping(path={"/", "/welcome"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request){
		
		List<HarvestItem> harvestItemsList = harvestDAO.getHarvestItemList();
		
		request.setAttribute("harvestItemsList", harvestItemsList);
		
		return "anonymous-item-view";
	}
	
	@RequestMapping(path="/anonymous-detail-view", method=RequestMethod.GET)
	public String getAnonymousDetailView(HttpServletRequest request) {
		
		int harvestItemId = Integer.parseInt(request.getParameter("harvestItemId"));
		
		HarvestItem detailCrop = harvestDAO.getHarvestItemById(harvestItemId);
		
		request.setAttribute("detailCrop", detailCrop);
		
		return "anonymous-detail-view";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm(HttpServletRequest reqeust){
		
		return "login";
	}
}
