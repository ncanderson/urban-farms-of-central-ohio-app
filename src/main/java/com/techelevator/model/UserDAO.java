package com.techelevator.model;

public interface UserDAO {

	public boolean searchForUsernameAndPassword(String userName, String password);
	
	public String selectTypeByUserName(String userName);
}
