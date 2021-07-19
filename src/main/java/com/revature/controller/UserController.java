package com.revature.controller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	private static Scanner scan = new Scanner(System.in);
	private static UserService userService = new UserService();
	private static AccountService accountService = new AccountService();

	public boolean login() {

		log.info("Choosed login option.");

		System.out.println("Enter your username");
		String response = scan.nextLine();

		boolean checkUser = userService.usernameTaken(response);

		if (checkUser == true) {

			User user = userService.findUserByUsername(response);

			System.out.println("Enter your password");

			String password = scan.nextLine();

			if (password.equals(user.getPassword())) {

				switch (user.getUserType()) {
				case COSTUMER:
					log.info("Opening User Menu.");
					userMenu(user);
					break;
				case EMPLOYEE:
					log.info("Opening Employee menu");
					employeeMenu(user);
					break;
				case ADMIN:
					log.info("Opening Admin menu.");
					adminMenu(user);
					break;

				}

			} else {
				System.out.println("That username does not exist.");
			}

		}

		return false;

	}

	private void adminMenu(User user) {
		// TODO Auto-generated method stub

	}

	private void employeeMenu(User user) {
		// TODO Auto-generated method stub

	}

	public boolean userMenu(User user) {

		System.out.println("What would you like to do?" + "1. View Account Balance" + "2. Make a deposit \n"
				+ "2. Make a withdrawal\n" + "3. Make a tranfer\n" + "4.View account information.\n" + "5. ");
		return false;

	}

}
