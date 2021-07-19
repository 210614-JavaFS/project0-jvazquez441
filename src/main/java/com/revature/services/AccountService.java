package com.revature.services;

import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;

public class AccountService {

	public static AccountDAO accountDao = new AccountDAOImpl();

	public List<Account> findAll() {
		return accountDao.findAll();
	};

	public List<Account> findUserAccounts(String username) {
		return accountDao.findUserAccounts(username);
	};

	public Account findByAccountId(int id) {
		return accountDao.findByAccountId(id);
	};

	public List<Account> findByAccountStatus(AccountStatus accStatus) {
		return accountDao.findByAccountStatus(accStatus);
	};

	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	};

	public boolean addAccount(Account account, String username) {
		return accountDao.addAccount(account, username);
	};

	public boolean changeAccountStatus(Account account) {
		return accountDao.changeAccountStatus(account);
	};

	public List<Account> findByAccountType(AccountType accType) {
		return accountDao.findByAccountType(accType);
	};

	public boolean transferMoney(Account account1, Account account2, double amount) {
		return accountDao.transferMoney(account1, account2, amount);
	};

	public boolean editBalance(int accountId, double amount) {
		return accountDao.editBalance(accountId, amount);
	};
}
