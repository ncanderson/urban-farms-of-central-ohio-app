package com.techelevator.model;

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
		
		String sqlSearchForUser = "SELECT email, password "+
			      "FROM user "
			      + "INNER JOIN credentials"
			      + "ON user.credentials_id = credentials.credentials_id"+
			      "WHERE email = ?";

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
	public String selectTypeByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
