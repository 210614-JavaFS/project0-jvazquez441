package com.revature;

import java.util.Scanner;

import com.revature.controller.UserController;

public class Driver {

	public static UserController userController = new UserController();

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to the Banking Account System.");
		System.out.println("What would you like to do?\n" + "1. Users\n" + "2. Exit program");

		String response = scan.nextLine();

		while (!response.equals("2")) {
			if (response.equals("1")) {
				userController.userMenu();
				System.out.println("Welcome to the Banking Account System.");
				System.out.println("What would you like to do?\n" + "1. Users\n" + "2. Exit program");

				response = scan.nextLine();
			} else {
				System.out.println("Not a valid choice. Please try again.");
				System.out.println("What would you like to do?\n" + "1. Users\n" + "2. Exit program");

				response = scan.nextLine();
			}
		}
	}

}
