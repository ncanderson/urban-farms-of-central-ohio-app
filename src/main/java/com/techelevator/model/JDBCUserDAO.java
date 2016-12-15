package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User.Type;
import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;
	
	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher){
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
			user.setUserId(results.getInt("user_id"));
		}	
		return user;
	}
	
	private void saveUser(User user) {
		user.getType().ordinal();//Enum integer to be stored in DB
	}

	@Override
	public List<Buyer> getAllBuyers() {
		
		String sqlSelectStatement = "SELECT buyer_id, buyer_name, address1, address2, city, state_code, zipcode, "
									+ "delivery_times, contact_phone, notes, is_active, description, "
									+ "apply_large_order_discount, discount "
									+"FROM buyer_information";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatement);
		
		List<Buyer> buyerList = new ArrayList<Buyer>();
		
		while(results.next()){
			Buyer buyer = new Buyer();
			buyer.setBuyerID(results.getInt("buyer_id"));
			buyer.setBuyerName(results.getString("buyer_name"));
			buyer.setAddress1(results.getString("address1"));
			buyer.setAddress2(results.getString("address2"));
			buyer.setCity(results.getString("city"));
			buyer.setStateCode(results.getString("state_code"));
			buyer.setZipCode(results.getInt("zipcode"));
			buyer.setDeliveryTime(results.getString("delivery_times"));
			buyer.setContactPhone(results.getString("contact_phone"));
			buyer.setNotes(results.getString("notes"));
			buyer.setActive(results.getBoolean("is_active"));
			buyer.setDescription(results.getString("description"));
			buyer.setApplyLargeOrderDiscount(results.getBoolean("apply_large_order_discount"));
			buyer.setDiscount(results.getFloat("discount"));
			
			buyerList.add(buyer);
		}
		return buyerList;
	}
	
	@Override
	public List<User> getAllBuyerUsers() {
		
		String sqlSelectStatment = "SELECT user_id, email, first_name, last_name, user_phone_number, buyer_name, users.is_active "
									+ "from users "
									+ "INNER JOIN buyer_information "
									+ "ON users.buyer_id = buyer_information.buyer_id "
									+ "WHERE user_type = 2";
			
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
		
		return mapBuyerUser(results);
	}

	@Override
	public List<User> getAllFarmers() {
		
		
		
		String sqlSelectStatment = "SELECT user_id, email, first_name, last_name, user_phone_number, is_global_admin, is_admin, is_active "
								   + "from users "
								   + "WHERE user_type = 1";
							
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment);
		
		return mapResultsToFarmerList(results);
	}
	
	
	@Override
	public User getUserById(int id) {

		String sqlSelectStatment = "SELECT user_id, email, first_name, last_name, user_phone_number, is_global_admin, is_admin, is_active "
				   + "from users "
				   + "WHERE user_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectStatment, id);

		return mapRowToFarmer(results);
	}
	
	@Override
	public void updateFarmer(User farmer, int userId) {
		
		String sqlUpdateStatement = "UPDATE users SET email = ?, first_name = ?, last_name = ?, user_phone_number = ?, is_active =? WHERE user_id = ?";
		
		jdbcTemplate.update(sqlUpdateStatement, farmer.getEmail(), farmer.getFirstName(), farmer.getLastName(), farmer.getPhoneNumber(), farmer.isActive(), userId);
		
	}
	
	@Override
	public void addNewFarmer(User user) {
		//TODO this method needs work, password, salt, credentials_id
		byte[] tempSalt = passwordHasher.generateRandomSalt();
		String tempPassword = new String(Base64.encode(tempSalt)).substring(0, 9);
		byte[] trueSalt = passwordHasher.generateRandomSalt();		
		String hashedPassword = passwordHasher.computeHash(tempPassword, trueSalt);
		
		String sqlInsertCredentialsStatement = "INSERT INTO credentials (password, salt) VALUES (?, ?)";
		jdbcTemplate.update(sqlInsertCredentialsStatement, hashedPassword, trueSalt);
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT credentials_id FROM credentials WHERE password = ?", hashedPassword);
		
		int credId = 0;
		while(results.next()){
			credId = results.getInt("credentials_id");
		}
				
		String sqlInsertStatement = "INSERT INTO users (credentials_id, first_name, last_name, email, user_type, user_phone_number, is_global_admin, is_admin, is_active, reset_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertStatement, credId, user.getFirstName(), user.getLastName(), user.getEmail(), 1, user.getPhoneNumber(), false, user.isAdmin(), user.isActive(), true);
		//TODO missing Step!!! Must email new famer new temp passsword
		
	}
	
	@Override
	public void addNewBuyerUser(User user, String org) {
		
		byte[] tempSalt = passwordHasher.generateRandomSalt();
		String tempPassword = new String(Base64.encode(tempSalt)).substring(0, 9);
		byte[] trueSalt = passwordHasher.generateRandomSalt();		
		String hashedPassword = passwordHasher.computeHash(tempPassword, trueSalt);
		
		String sqlInsertCredentialsStatement = "INSERT INTO credentials (password, salt) VALUES (?, ?)";
		jdbcTemplate.update(sqlInsertCredentialsStatement, hashedPassword, trueSalt);
		
		SqlRowSet results1 = jdbcTemplate.queryForRowSet("SELECT credentials_id FROM credentials WHERE password = ?", hashedPassword);
		
		int credId = 0;
		while(results1.next()){
			credId = results1.getInt("credentials_id");
		}
		
		SqlRowSet results2 = jdbcTemplate.queryForRowSet("SELECT buyer_id FROM buyer_information WHERE buyer_name = ?", org);
		
		int buyerId = 0;
		while(results1.next()){
			buyerId = results1.getInt("buyer_id");
		}
				
		String sqlInsertStatement = "INSERT INTO users (credentials_id, buyer_id, first_name, last_name, email, user_type, user_phone_number, is_global_admin, is_admin, is_active, reset_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertStatement, credId, buyerId, user.getFirstName(), user.getLastName(), user.getEmail(), 0, user.getPhoneNumber(), false, user.isAdmin(), user.isActive(), true);
		//TODO missing Step!!! Must email new buyer new temp passsword
			
	}
	
	@Override
	public int getBuyerByUserId(int userId) {
		
		String sqlSelectStatement = "SELECT buyer_id FROM users WHERE user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectStatement, userId);
		
		int buyerId = 0;
		while(result.next()){
			buyerId = result.getInt("buyer_id");
		}
		return buyerId;
	}
	
	private List<User> mapResultsToFarmerList(SqlRowSet results){
		
		List<User> allFarmers = new ArrayList<User>();
		
		while(results.next()){
			
			User user = new User();
			user.setUserId(results.getInt("user_id"));
			user.setEmail(results.getString("email"));
			user.setFirstName(results.getString("first_name"));
			user.setLastName(results.getString("last_name"));
			user.setPhoneNumber(results.getString("user_phone_number"));
			user.setGlobalAdmin(Boolean.valueOf(results.getString("is_global_admin")));
			user.setAdmin(Boolean.valueOf(results.getString("is_admin")));
			user.setActive(Boolean.valueOf(results.getString("is_active")));
			
			allFarmers.add(user);
		}
		
		return allFarmers;
	}
	
	private User mapRowToFarmer(SqlRowSet results){
		
		User user = new User();
		while(results.next()){
			
			user.setUserId(results.getInt("user_id"));
			user.setEmail(results.getString("email"));
			user.setFirstName(results.getString("first_name"));
			user.setLastName(results.getString("last_name"));
			user.setPhoneNumber(results.getString("user_phone_number"));
			user.setGlobalAdmin(Boolean.valueOf(results.getString("is_global_admin")));
			user.setAdmin(Boolean.valueOf(results.getString("is_admin")));
			user.setActive(Boolean.valueOf(results.getString("is_active")));
			
		}
		
		return user;
	}
	
	private List<User> mapBuyerUser(SqlRowSet results){
		
	List<User> allBuyerUsers = new ArrayList<User>();
		
		while(results.next()){
			
			User user = new User();
			user.setUserId(results.getInt("user_id"));
			user.setEmail(results.getString("email"));
			user.setFirstName(results.getString("first_name"));
			user.setLastName(results.getString("last_name"));
			user.setPhoneNumber(results.getString("user_phone_number"));	
			user.setCompanyName(results.getString("buyer_name"));
			user.setActive(Boolean.valueOf(results.getString("is_active")));
			
			allBuyerUsers.add(user);
		}
		return allBuyerUsers;		
	}
}
