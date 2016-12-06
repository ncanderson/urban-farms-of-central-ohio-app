package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.HarvestDAO;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;


@Controller 
public class HomeController {
	
	private HarvestDAO harvestDAO;
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	
	@Autowired
	public HomeController(UserDAO userDAO, HarvestDAO harvestDAO){
		this.userDAO = userDAO;
		this.harvestDAO = harvestDAO;
	}
	
	@RequestMapping(path={"/, /welcome"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request){
		
		List<Item> itemList = harvestDAO.getHarvestItemList();
		request.setAttribute("itemList", itemList);
		
		return "welcome";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm(){
		
		return "login";
	}

}
