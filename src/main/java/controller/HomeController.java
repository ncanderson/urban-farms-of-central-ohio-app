package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Item;
import model.ItemDAO;
import model.UserDAO;

@Controller 
public class HomeController {
	
	private ItemDAO itemDAO;
	private UserDAO userDAO;
	
	@Autowired
	public HomeController(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@RequestMapping(path={"/, /welcome"}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request){
		
		List<Item> itemList = itemDAO.getItemList();
		request.setAttribute("itemList", itemList);
		
		return "welcome";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm(){
		
		return "login";
	}

}
