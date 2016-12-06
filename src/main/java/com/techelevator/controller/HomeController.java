package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Item;
import com.techelevator.model.ItemDAO;
import com.techelevator.model.UserDAO;

@Controller 
public class HomeController {
	
//	private ItemDAO itemDAO;
//	private UserDAO userDAO;
	
	public HomeController(){
//		this.userDAO = userDAO;
	}
	
	@RequestMapping(path={"/", "/welcome"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request){
		
//		List<Item> itemList = itemDAO.getItemList();
//		request.setAttribute("itemList", itemList);
		
		return "anonymous-item-view";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm(){
		
		return "login";
	}

}
