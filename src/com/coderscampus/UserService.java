package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserService {

	public User createUser(String[] args) {

		User user = new User();
		
		user.setUsername(args[0]);
		user.setPassword(args[1]);
		user.setName(args[2]);

		
		
		return user;
	}
	
	public BufferedReader getData() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
		
		
	}
	
	
	

}