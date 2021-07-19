package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;

public interface AccountDAO {

	public List<Account> findAll();

	public List<Account> findUserAccounts(String username);

	public Account findByAccountId(int id);

	public List<Account> findByAccountStatus(AccountStatus accStatus);

	public boolean updateAccount(Account account);

	public boolean addAccount(Account account, String username);

	public boolean changeAccountStatus(Account account);
	
	public List<Account> findByAccountType(AccountType accType);
	
	public boolean transferMoney (Account account1, Account account2, double amount);
	
	public boolean editBalance(int accountId, double amount);

}
