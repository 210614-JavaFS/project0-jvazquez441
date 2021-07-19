package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;
import com.revature.utils.ConnectionUtil;

// ***************** ADD BEGIN COMMIT LOGGER TO ALL

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			List<Account> allAccounts = new ArrayList<>();

			String sql = "SELECT * FROM accounts;";

			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				Account account = new Account();

				account.setAccountId(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountBalance(rs.getDouble("account_balance"));

				int accountType = rs.getInt("account_type");

				if (accountType == 1) {
					account.setAccountType(AccountType.CHECKING);
				} else if (accountType == 2) {
					account.setAccountType(AccountType.SAVINGS);
				} else {
					account.setAccountType(AccountType.JOINT);
				}

				int accountStatus = rs.getInt("account_status");

				if (accountStatus == 1) {
					account.setAccountStatus(AccountStatus.ACTIVE);
				} else if (accountStatus == 2) {
					account.setAccountStatus(AccountStatus.CLOSED);
				} else {
					account.setAccountStatus(AccountStatus.PENDING);
				}

				allAccounts.add(account);
			}

			return allAccounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findUserAccounts(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT account_id, account_name, account_balance, account_type, account_status FROM accounts"
					+ "LEFT JOIN account_owners  ON accounts.account_id = account_owners.account_fk WHERE account_owners.user_fk = ?;";

			List<Account> userAccounts = new ArrayList<>();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(sql);

			ps.setString(1, username);

			while (rs.next()) {

				Account account = new Account();

				account.setAccountId(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountBalance(rs.getDouble("account_balance"));

				int accountType = rs.getInt("account_type");

				if (accountType == 1) {
					account.setAccountType(AccountType.CHECKING);
				} else if (accountType == 2) {
					account.setAccountType(AccountType.SAVINGS);
				} else {
					account.setAccountType(AccountType.JOINT);
				}

				int accountStatus = rs.getInt("account_status");

				if (accountStatus == 1) {
					account.setAccountStatus(AccountStatus.ACTIVE);
				} else if (accountStatus == 2) {
					account.setAccountStatus(AccountStatus.CLOSED);
				} else {
					account.setAccountStatus(AccountStatus.PENDING);
				}

				userAccounts.add(account);
			}

			return userAccounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findByAccountId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE account_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			ps.setInt(1, id);

			Account account = new Account();

			if (rs.next()) {
				account.setAccountId(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountBalance(rs.getDouble("account_balance"));

				int accountType = rs.getInt("account_type");

				if (accountType == 1) {
					account.setAccountType(AccountType.CHECKING);
				} else if (accountType == 2) {
					account.setAccountType(AccountType.SAVINGS);
				} else {
					account.setAccountType(AccountType.JOINT);
				}

				int accountStatus = rs.getInt("account_status");

				if (accountStatus == 1) {
					account.setAccountStatus(AccountStatus.ACTIVE);
				} else if (accountStatus == 2) {
					account.setAccountStatus(AccountStatus.CLOSED);
				} else {
					account.setAccountStatus(AccountStatus.PENDING);
				}
			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE accounts SET account_name = ?, account_balance = ?, account_type = ?, account_status = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setString(++index, account.getAccountName());
			ps.setDouble(++index, account.getAccountBalance());

			int accountType = 0;

			if (account.getAccountType().equals(AccountType.CHECKING)) {
				accountType = 1;
			} else if (account.getAccountType().equals(AccountType.SAVINGS)) {
				accountType = 2;
			} else {
				accountType = 3;
			}

			ps.setInt(++index, accountType);

			int accountStatus = 0;

			if (account.getAccountStatus().equals(AccountStatus.ACTIVE)) {
				accountStatus = 1;
			} else if (account.getAccountStatus().equals(AccountStatus.CLOSED)) {
				accountStatus = 2;
			} else {
				accountStatus = 3;
			}

			ps.setInt(++index, accountStatus);

			ps.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addAccount(Account account, String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO accounts (account_name, account_balance, account_type, account_status)"
					+ "VALUES (?,?,?,?);" + "INSERT INTO account_owners (user_fk,account_fk)"
					+ "VALUES (?,(SELECT MAX(account_id) FROM accounts));";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setString(++index, account.getAccountName());
			ps.setDouble(++index, account.getAccountBalance());

			int accountType = 0;

			if (account.getAccountType().equals(AccountType.CHECKING)) {
				accountType = 1;
			} else if (account.getAccountType().equals(AccountType.SAVINGS)) {
				accountType = 2;
			} else {
				accountType = 3;
			}

			ps.setInt(++index, accountType);

			int accountStatus = 0;

			if (account.getAccountStatus().equals(AccountStatus.ACTIVE)) {
				accountStatus = 1;
			} else if (account.getAccountStatus().equals(AccountStatus.CLOSED)) {
				accountStatus = 2;
			} else {
				accountStatus = 3;
			}

			ps.setInt(++index, accountStatus);

			ps.setString(++index, username);

			ps.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Account> findByAccountStatus(AccountStatus accStatus) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			int accountStatus = 0;

			if (accStatus.equals(AccountStatus.ACTIVE)) {
				accountStatus = 1;
			} else if (accStatus.equals(AccountStatus.CLOSED)) {
				accountStatus = 2;
			} else {
				accountStatus = 3;
			}

			String sql = "SELECT * FROM accounts WHERE account_status = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			ps.setInt(1, accountStatus);

			List<Account> accountList = new ArrayList<>();

			while (rs.next()) {
				Account account = new Account();

				account.setAccountId(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountBalance(rs.getDouble("account_balance"));

				int accountType = rs.getInt("account_type");

				if (accountType == 1) {
					account.setAccountType(AccountType.CHECKING);
				} else if (accountType == 2) {
					account.setAccountType(AccountType.SAVINGS);
				} else {
					account.setAccountType(AccountType.JOINT);
				}

				account.setAccountStatus(accStatus);

				accountList.add(account);
			}

			return accountList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findByAccountType(AccountType accType) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			int accountType = 0;

			if (accType.equals(AccountType.CHECKING)) {
				accountType = 1;
			} else if (accType.equals(AccountType.SAVINGS)) {
				accountType = 2;
			} else {
				accountType = 3;
			}

			String sql = "SELECT * FROM accounts WHERE account_type = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			ps.setInt(1, accountType);

			List<Account> accountList = new ArrayList<>();

			while (rs.next()) {
				Account account = new Account();

				account.setAccountId(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountBalance(rs.getDouble("account_balance"));
				account.setAccountType(accType);

				int accountStatus = rs.getInt("account_status");

				if (accountStatus == 1) {
					account.setAccountStatus(AccountStatus.ACTIVE);
				} else if (accountStatus == 2) {
					account.setAccountStatus(AccountStatus.CLOSED);
				} else {
					account.setAccountStatus(AccountStatus.PENDING);
				}

				accountList.add(account);
			}

			return accountList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean transferMoney(Account account1, Account account2, double amount) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE accounts SET account_balance = ?  WHERE account_id = ?;"
					+ "UPDATE accounts SET account_balance = ? WHERE account_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setDouble(++index, account1.getAccountBalance() - amount);
			ps.setInt(++index, account1.getAccountId());

			ps.setDouble(++index, account2.getAccountBalance());
			ps.setInt(++index, account2.getAccountId());

			ps.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editBalance(int accountId, double amount) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE accounts SET account_balance = ? WHERE account_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setDouble(++index, amount);
			ps.setInt(++index, accountId);

			ps.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeAccountStatus(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
