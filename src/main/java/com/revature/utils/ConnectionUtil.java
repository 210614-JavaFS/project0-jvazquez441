package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://java-react-210614.cjsjzzixk8hp.us-east-2.rds.amazonaws.com:5432/projectzero";
		String username = "postgres";
		String password = "password";

		return DriverManager.getConnection(url, username, password);
	}

//	public static void main(String[] args) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			System.out.println("Connection Successful");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
