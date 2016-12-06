package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.UserDAO;

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
			model.put("currentUser", userName);

			//TODO get user type  and rout to correct view
			
		}	
		
		return null;
		
	}
	
	
	
}
