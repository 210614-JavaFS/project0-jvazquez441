package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDAO {

	public List<User> findAll();

	public boolean usernameTaken(String username);

	public boolean createUser(User u);

	public boolean updateUser(User u);

	public User findUserByNameAndSSN(String firstName, String lastName, String ssn);

	public User findUserByUsername(String username);

}
