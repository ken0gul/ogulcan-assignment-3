package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		// Let's create a string first
		String[] users = new String[4];
		// Global variables
		User test = null;
		String[] usernames = new String[4];
		String[] passwords = new String[4];
		String[] names = new String[4];
		Boolean loginSuccess = false;

		
		// Instantiate a new object from UserService
		UserService user1 = new UserService();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				// Create an array of users
				users[i] = line;
				i++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 4; i++) {

			// Populate test (User object) with the data received from data.txt file as an array
			test = user1.createUser(users[i].split(","));
			// get usernames, passwords and names as Strings and store them in to different arrays
			usernames[i] = test.getUsername();
			passwords[i] = test.getPassword();
			names[i] = test.getName();

		}

		try (// Create a Scanner to get input from the console
				Scanner scanner = new Scanner(System.in)) {
			int i = 0;
			outerloop: while (i < 5) {

				String username = scanner.nextLine();
				String password = scanner.nextLine();

				// Check for validation

				for (int j = 0; j < 4; j++) {
					if (usernames[j].toLowerCase().matches(username) && passwords[j].matches(password)) {
						System.out.println("Welcome " + names[j]);
						loginSuccess = true;
						break outerloop;
					}

				}
				// If login is not successfull print the line below
				if (loginSuccess == false) {
					System.out.println("Invalid Login Attempt! Try Again.");
				}

//				
//			if (usernames[i].toLowerCase().equals(username.toLowerCase()) && passwords[i].equals(password)) {
//				System.out.println("Welcome " + names[i]);
//			} 

//
//			int j = 0;
//			while (j < 4) {
//				++j;
//				if (usernames[j].toLowerCase().equals(username.toLowerCase()) && passwords[j].equals(password)) {
//
//					System.out.println("Welcome " + names[j]);
//					i = 5;
//					loginSuccess = true;
//					break;
//				} else {
//					System.out.println("Invalid input");
//					break;
//				}
//
//			}
			}
			// If loginSuccess is still false when the loop is over then print the line below
			if (loginSuccess == false) {
				System.out.println("Too many failed login attempts, you are now locked out.");
			}

			scanner.close();
		}

	}

}
