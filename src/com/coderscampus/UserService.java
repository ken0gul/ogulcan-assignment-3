package com.coderscampus;



public class UserService {

	public User createUser(String[] args) {

		User user = new User();
		
		user.setUsername(args[0]);
		user.setPassword(args[1]);
		user.setName(args[2]);

		

		return user;
	}
	
	
	
}