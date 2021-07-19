package com.revature.model;

import java.util.ArrayList;

public class Account {

	private int accountId;
	private String accountName;
	private double accountBalance;
	private AccountType accountType;
	private AccountStatus accountStatus;
	private ArrayList<User> accountOwners;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountName, double accountBalance, AccountType accountType,
			AccountStatus accountStatus, ArrayList<User> accountOwners) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountOwners = accountOwners;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public ArrayList<User> getAccountOwners() {
		return accountOwners;
	}

	public void setAccountOwners(ArrayList<User> accountOwners) {
		this.accountOwners = accountOwners;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountId;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountOwners == null) ? 0 : accountOwners.hashCode());
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId != other.accountId)
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountOwners == null) {
			if (other.accountOwners != null)
				return false;
		} else if (!accountOwners.equals(other.accountOwners))
			return false;
		if (accountStatus != other.accountStatus)
			return false;
		if (accountType != other.accountType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountBalance=" + accountBalance
				+ ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", accountOwners="
				+ accountOwners + "]";
	}

}
