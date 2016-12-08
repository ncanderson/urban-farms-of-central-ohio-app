package com.techelevator.model;

import java.util.List;

public interface UserDAO {

	public boolean searchForUsernameAndPassword(String userName, String password);
	
	public User selectUserByUserName(String userName);
	
	public List<Buyer> getAllBuyers();

}
