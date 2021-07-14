package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account findByAccountId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByAccountOwner(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByAccountStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAccount(Account account, List<User> owners) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOwner(User owner) {
		// TODO Auto-generated method stub
		return false;
	}

}
