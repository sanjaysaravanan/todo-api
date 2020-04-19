package com.example.demo.user;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserHardCodedService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(
				"Sanjay Saravanan",
				new Date(),
				new BigInteger("9790889427"),
				"sanjaysaravanan38@gmail.com")
			);
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User createUser(User user) {
		users.add(user);
		return user;
	}
	
}
