package com.softra.banking;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.AccountLockedException;
import com.softra.banking.Exception.UserNotFoundException;


// return type will be in json
@RestController
public class LoginResource {
	
	// FIELD injection --> don't need to create instances in order, unless it's CONSTRUCTOR/SETTER injection
	@Autowired
	@Qualifier("user")
	private IService<User> service;
	
	private static int fail_count = 0;
	
	public LoginResource() {
		System.out.println("inside userResource default constructor");
	}
	
	@PostMapping(path = "/login") // same as below
	public User authenticateUser(@RequestBody User u) throws AccountLockedException {
		System.out.println("inside retrieveUser");

		User user = service.findById(u.getId());
		
		if (fail_count >= 3) {
			user.setLock_status(true); 
			throw new AccountLockedException("You have exceeded the number of login attempts. Please contact the bank to unlock your account.");
		}
	
		
		if ( user.getId() == 0 ) {
			fail_count += 1;
			throw new UserNotFoundException("User with id " + u.getId() + " not found");
		}
		
		System.out.println(user);
		if (user.getLogin_password() != u.getLogin_password()) {
			fail_count += 1;
		}
		
		return user;
	}

}
