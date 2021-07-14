package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.model.User;
import com.revature.services.UserService;

public class UserController {

	private static UserService userService = new UserService();
	Scanner scan = new Scanner(System.in);

	public void userMenu() {
		System.out.println("What would you l ike to do with the user?\n" + "1. See all users\n"
				+ "2. See only one user\n" + "3. Add a new user\n" + "4. Return to previous menu.");

		String resp = scan.nextLine();

		switch (resp) {
		case "1":
			showAllUsers();
			break;
		case "2":
			showOneUser();
			break;
		case "3":
			addUser();
			break;
		case "4":
			return;
		default:
			return;

		}
	}

	private void addUser() {
		System.out.println("What is you username");
		String userName = scan.nextLine();
		System.out.println("Enter a password for your account");
		String password = scan.nextLine();
		System.out.println("Enter your First name");
		String firstName = scan.nextLine();
		System.out.println("Enter your Last name");
		String lastName = scan.nextLine();

		int userType = 1;

		System.out.println("Enter your date of birth in yyyy-mm-dd");
		String date = scan.nextLine();

		java.sql.Date sqlDate = java.sql.Date.valueOf(date);

		User user = new User(userName, password, firstName, lastName, userType, sqlDate);

		if (userService.addUser(user)) {
			System.out.println("The user was added.");
		} else {
			System.out.println("Something went wrong. User was not added.");
		}
	}

	private void showOneUser() {
		System.out.println("Enter the username: ");

		String response = scan.nextLine();

		User user = userService.getUser(response);

		if (user != null) {
			System.out.println("\n");
			System.out.println(user.toString());

		} else {
			System.out.println("User not valid");
			showOneUser();
		}

	}

	public void showAllUsers() {
		List<User> users = userService.getAllUsers();

		for (User u : users) {
			System.out.println(u);
		}
	}

}
