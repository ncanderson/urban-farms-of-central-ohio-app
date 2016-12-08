package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;
	
	@Autowired
	public JDBCUserDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.passwordHasher = new PasswordHasher();
	}
	
	@Override
	public boolean searchForUsernameAndPassword(String userName, String password) {
		
		String sqlSearchForUser = "SELECT password, salt "
			      +"FROM users "
			      +"INNER JOIN credentials "
			      +"ON users.credentials_id = credentials.credentials_id "
			      +"WHERE email = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName);
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(hashedPassword);
		} else {
			return false;
		}
	}

	@Override
	public User selectUserByUserName(String userName) {
		
		String sqlSelectStatment = "SELECT user_id, user_type, first_name, last_name, "
				+ "user_phone_number, is_global_admin, is_admin, is_active "
				+ "FROM users "
				+ "WHERE email = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment, userName);
		User user = mapResultToUser(results, userName);
		
		return user;
	}
	
	
	private User mapResultToUser(SqlRowSet results, String userName){
		User user = new User();
		
		while(results.next()){
			user.setAdmin(results.getBoolean("is_admin"));
			user.setEmail(userName);
			user.setFirstName(results.getString("first_name"));
			user.setLastName(results.getString("last_name"));
			user.setGlobalAdmin(results.getBoolean("is_global_admin"));
			user.setPhoneNumber(results.getString("user_phone_number"));
			user.setType(User.Type.values()[results.getInt("user_type")]);
			user.setUserID(results.getInt("user_id"));
		}	
		return user;
	}
	
	private void saveUser(User user) {
		user.getType().ordinal();//Enum integer to be stored in DB
	}

	@Override
	public List<User> getAllCustomers() {
		User user = new User();
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		return userList;
	}


}
