package com.softra.banking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.AccountLockedException;
import com.softra.banking.Exception.UserNotFoundException;


// return type will be in json
@RestController
@CrossOrigin("*")
public class LoginResource {
	
	// FIELD injection --> don't need to create instances in order, unless it's CONSTRUCTOR/SETTER injection
	@Autowired
	@Qualifier("user")
	private IService<User> service;
	
	@Autowired
	UserJpaRepository userJpa;
	
	private static int fail_count = 0;
	
	public LoginResource() {
		System.out.println("inside userResource default constructor");
	}
	
	@PostMapping(path = "/login") // same as below
	public User authenticateUser(@RequestBody User u) throws AccountLockedException {
		System.out.println("inside retrieveUser of LoginResource");
		
		User user = null;
		
		if (fail_count >= 3) {
			user.setLock_status(true); 
			throw new AccountLockedException("You have exceeded the number of login attempts. Please contact the bank to unlock your account.");
		}
		
		try {
			user = userJpa.findByEmail(u.getEmail());
			System.out.println("Current email is: " + user.getEmail());
			
		} catch(Exception e) {
			fail_count += 1;
			throw new UserNotFoundException("User with email " + u.getEmail() + " not found, fail attempt: " + fail_count);
		}
		
		if(!user.getLogin_password().equals(u.getLogin_password())) {
			fail_count += 1;
			throw new UserNotFoundException("Incorrect passowrd, fail attempt: " + fail_count);
		} 
		
		return user;
		
	}

}
