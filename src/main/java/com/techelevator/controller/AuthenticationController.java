package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.UserDAO;
import com.techelevator.model.User;
import com.techelevator.model.User.Type;

@Controller
@SessionAttributes("currentUser")
public class AuthenticationController {
	
	private UserDAO userDAO;
	
	@Autowired
	public AuthenticationController(UserDAO userDAO){
		this.userDAO = userDAO;
	}

	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String userName, @RequestParam String password,
						HttpSession session){
		
		if(userDAO.searchForUsernameAndPassword(userName, password)){ 
			session.invalidate();
				
			User user = userDAO.selectUserByUserName(userName);		
			model.put("currentUser", user);
			
			switch(user.getType()){
			
				case ADMIN: 
							return "redirect:/admin/admin-main-view";
							
				case FARMER: 
							return "redirect:/farmer-dashboard-views/dashboard";
				
				case BUYER: 
							return "redirect:/customer-views/current-inventory";
				
				default : 
							return "redirect:/welcome";
			}
			
		}	
		
		return "redirect:/login";
		
	}	
}
