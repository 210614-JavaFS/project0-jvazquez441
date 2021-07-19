package com.revature.model;

import java.sql.Date;
import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String Address;
	private String ssn;
	private String phoneNumber;
	private Date DoB;

	private UserType userType;

	private ArrayList<Account> userBankAccounts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstName, String lastName, String address, String ssn,
			String phoneNumber, Date doB, UserType userType, ArrayList<Account> userBankAccounts) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		DoB = doB;
		this.userType = userType;
		this.userBankAccounts = userBankAccounts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDoB() {
		return DoB;
	}

	public void setDoB(Date doB) {
		DoB = doB;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public ArrayList<Account> getUserBankAccounts() {
		return userBankAccounts;
	}

	public void setUserBankAccounts(ArrayList<Account> userBankAccounts) {
		this.userBankAccounts = userBankAccounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((DoB == null) ? 0 : DoB.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((userBankAccounts == null) ? 0 : userBankAccounts.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (DoB == null) {
			if (other.DoB != null)
				return false;
		} else if (!DoB.equals(other.DoB))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (userBankAccounts == null) {
			if (other.userBankAccounts != null)
				return false;
		} else if (!userBankAccounts.equals(other.userBankAccounts))
			return false;
		if (userType != other.userType)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", Address=" + Address + ", ssn=" + ssn + ", phoneNumber=" + phoneNumber + ", DoB=" + DoB
				+ ", userType=" + userType + ", userBankAccounts=" + userBankAccounts + "]";
	}

}
