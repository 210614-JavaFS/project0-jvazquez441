package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.User;
import com.revature.model.UserType;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	public List<User> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users";
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			List<User> userList = new ArrayList<>();

			while (rs.next()) {
				User user = new User();

				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAddress(rs.getString("address"));
				user.setSsn(rs.getString("ssn"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setDoB(rs.getDate("dob"));
				int user_type = rs.getInt("user_type");

				if (user_type == 1) {
					user.setUserType(UserType.COSTUMER);
				} else if (user_type == 2) {
					user.setUserType(UserType.EMPLOYEE);
				} else {
					user.setUserType(UserType.ADMIN);
				}

				userList.add(user);

			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public boolean createUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO users (username, pw, first_name, last_name, address, ssn, phone_number, dob, user_type) "
					+ "VALUES (?,?,?,?,?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setString(++index, u.getUsername());
			ps.setString(++index, u.getPassword());
			ps.setString(++index, u.getFirstName());
			ps.setString(++index, u.getLastName());
			ps.setString(++index, u.getSsn());
			ps.setString(++index, u.getPhoneNumber());
			ps.setDate(++index, u.getDoB());

			if (u.getUserType().equals(UserType.COSTUMER)) {
				ps.setInt(++index, 1);
			} else if (u.getUserType().equals(UserType.EMPLOYEE)) {
				ps.setInt(++index, 2);
			} else {
				ps.setInt(++index, 3);
			}

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = " UPDATE users "
					+ "SET pw = ?, first_name = ?, last_name = ?, address = ?, ssn = ?, phone_number = ?, dob = ?, user_type = ? WHERE username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ps.setString(++index, u.getPassword());
			ps.setString(++index, u.getFirstName());
			ps.setString(++index, u.getLastName());
			ps.setString(++index, u.getSsn());
			ps.setString(++index, u.getPhoneNumber());
			ps.setDate(++index, u.getDoB());

			if (u.getUserType().equals(UserType.COSTUMER)) {
				ps.setInt(++index, 1);
			} else if (u.getUserType().equals(UserType.EMPLOYEE)) {
				ps.setInt(++index, 2);
			} else {
				ps.setInt(++index, 3);
			}
			ps.setString(++index, u.getUsername());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public User findUserByNameAndSSN(String firstName, String lastName, String ssn) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE first_name = ? AND last_name = ? AND snn = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 0;

			ResultSet rs = ps.executeQuery();

			ps.setString(++index, firstName);
			ps.setString(++index, lastName);
			ps.setString(++index, ssn);

			User user = new User();

			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAddress(rs.getString("address"));
				user.setSsn(rs.getString("ssn"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setDoB(rs.getDate("dob"));
				int user_type = rs.getInt("user_type");

				if (user_type == 1) {
					user.setUserType(UserType.COSTUMER);
				} else if (user_type == 2) {
					user.setUserType(UserType.EMPLOYEE);
				} else {
					user.setUserType(UserType.ADMIN);
				}

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			User user = new User();

			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAddress(rs.getString("address"));
				user.setSsn(rs.getString("ssn"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setDoB(rs.getDate("dob"));
				int user_type = rs.getInt("user_type");

				if (user_type == 1) {
					user.setUserType(UserType.COSTUMER);
				} else if (user_type == 2) {
					user.setUserType(UserType.EMPLOYEE);
				} else {
					user.setUserType(UserType.ADMIN);
				}

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean usernameTaken(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT username FROM users WHERE username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
