package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;

public interface AccountDAO {

	public Account findByAccountId(int id);

	public List<Account> findByAccountOwner(String username);

	public List<Account> findByAccountStatus(String status);

	public boolean updateAccount(Account account);

	boolean addAccount(Account account, List<User> owners);

	boolean addOwner(User owner);
}
