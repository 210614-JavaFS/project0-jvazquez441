package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.User;

public class UserService {
//	private static Logger log = LoggerFactory.getLogger(UserService.class);

	public static UserDAO userDao = new UserDAOImpl();

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User getUser(String username) {
		return userDao.findByUsername(username);
	}
	
	public boolean addUser(User u) {
		return userDao.registerUser(u);
	}
	
	public boolean updateUser(User u) {
		return userDao.updateUser(u);
	}

}
