package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean registerUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (username,pw,first_name,last_name, user_type, dob) VALUES (?,?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			int index = 0;
			
			
			ps.setString(++index, u.getUsername());
			ps.setString(++index, u.getPassword());
			ps.setString(++index, u.getFirstName());
			ps.setString(++index, u.getLastName());
			ps.setInt(++index, u.getUserType());
			ps.setDate(++index, u.getDoB());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE users SET pw = ?, first_name = ?, last_name = ?, user_type = ?, dob = ? WHERE username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, u.getPassword());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setInt(4, u.getUserType());
			ps.setDate(5, u.getDoB());
			ps.setString(6, u.getUsername());

			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByName(String firstName, String lastName) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users WHERE first_name = ? AND last_name = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, firstName);
			ps.setString(2, lastName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6));

				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Username not found");
		}

		return null;
	}

	@Override
	public User findByUsername(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6));

				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Username not found");
		}

		return null;
	}

	@Override
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
				user.setUserType(rs.getInt("user_type"));
				user.setDoB(rs.getDate("dob"));

				userList.add(user);

			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
