package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.User;

public class UserService {
	
	public static UserDAO userDao = new UserDAOImpl();
	
	public List<User> findAll(){
		return userDao.findAll();
	};
	
	public boolean usernameTaken(String username) {
		return userDao.usernameTaken(username);
	};

	public boolean createUser(User u) {
		return userDao.createUser(u);
	};

	public boolean updateUser(User u) {
		return userDao.updateUser(u);
	};

	public User findUserByNameAndSSN(String firstName, String lastName, String ssn) {
		return userDao.findUserByNameAndSSN(firstName, lastName, ssn);
	};

	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	};
}
