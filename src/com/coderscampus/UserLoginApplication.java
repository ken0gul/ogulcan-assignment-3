package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Let's create a string first
		String[] users = new String[4];
		
		UserService user1 = new UserService();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line;
			int i = 0;
			while((line = reader.readLine()) != null) {
				// Create an array of users
				users[i] =line;
				i++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 4; i ++) {
			
			user1.createUser(users[i].split(","));
		}
		
		

	}

}
