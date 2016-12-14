package com.techelevator.model;

import java.util.List;

public interface UserDAO {

	public boolean searchForUsernameAndPassword(String userName, String password);
	
	public User selectUserByUserName(String userName);
	
	public List<Buyer> getAllBuyers();
	
	public List<User> getAllBuyerUsers();
	
	public List<User> getAllFarmers();
	
	public User getUserById(int id);
	
	public void updateFarmer(User farmer, int userId);
	
	public void addNewFarmer(User user);

}
