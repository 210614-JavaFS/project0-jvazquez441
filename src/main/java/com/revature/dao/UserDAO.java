package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.model.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public boolean registerUser(User u);

	public boolean updateUser(User u);

	public User findByName(String firstName, String lastName);

	public User findByUsername(String username);

}
