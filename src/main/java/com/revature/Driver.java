package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {
	public static Logger log = LoggerFactory.getLogger(Driver.class);
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		log.info("Program Starting at Driver.java main().");

		boolean exit = false;

		System.out.println("Welcome to the PokeBank!\n");

		while (!exit) {
			System.out.println("What would you likt to do?\n");
			System.out.println("1. Create a new user account.");
			System.out.println("2. Login.");
			System.out.println("1. Exit PokeBank.");

			String response = scan.nextLine();

			switch (response) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			default:
				break;
			}

		}

	}
}
