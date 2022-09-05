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

			test = user1.createUser(users[i].split(","));
			usernames[i] = test.getUsername();
			passwords[i] = test.getPassword();
			names[i] = test.getName();

		}

		// Create a Scanner to get input from the console
		Scanner scanner = new Scanner(System.in);

		// A for loop for 5 login attempts
		for (int i = 0; i < 5; i++) {

			String username = scanner.nextLine();
			String password = scanner.nextLine();

			// Check for validation
			
			
			

			int j = 0;
			while (j < 4) {
				++j;
				if (usernames[j].toLowerCase().equals(username.toLowerCase()) && passwords[j].equals(password)) {

					System.out.println("Welcome " + names[j]);
					i = 5;
					loginSuccess = true;
					break;
				} else {
					System.out.println("Invalid input");
					break;
				}

			}
		}
		
		
		scanner.close();
		if (loginSuccess == false) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}

	}

}
