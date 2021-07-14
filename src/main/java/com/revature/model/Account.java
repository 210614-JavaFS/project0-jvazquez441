package com.revature.model;

import java.util.List;

public class Account {

	private int accountId; // Account Number
	private double balance;
	private String accountType;
	private String accountStatus;
	private List<User> accountOwners;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, double balance, String accountType, String accountStatus, List<User> accountOwners) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountOwners = accountOwners;
	}

	public Account(double balance, String accountType, String accountStatus, List<User> accountOwners) {
		super();
		this.balance = balance;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public List<User> getAccountOwners() {
		return accountOwners;
	}

	public void setAccountOwners(List<User> accountOwners) {
		this.accountOwners = accountOwners;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountOwners == null) ? 0 : accountOwners.hashCode());
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (accountId != other.accountId)
			return false;
		if (accountOwners == null) {
			if (other.accountOwners != null)
				return false;
		} else if (!accountOwners.equals(other.accountOwners))
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", accountOwners=" + accountOwners + "]";
	}

}
