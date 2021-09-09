package com.softra.banking;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.UserNotFoundException;


@RestController
public class UserResource {
	
	@Autowired
	@Qualifier("user")
	private IService<User> service;
	
	public UserResource() {
		System.out.println("inside userResource default constructor");
	}
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		System.out.println("inside retrieveAllUsers");
		List<User> users = service.findAll();
		return users;
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		System.out.println("inside retrieveUser");
		User user = service.findById(id);
		if ( user== null) {
			throw new UserNotFoundException("User with id " + id + " not found");
		}
		return user;
	}
	
	@PostMapping(path = "/users")
	public User createUser (@Valid @RequestBody User user) {
		System.out.println("inside createUser" + user);
		return service.save(user);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public User deleteUser (@PathVariable int id) {
		System.out.println("inside deleteUser");
		return service.deleteById(id);
	}
	
	// doesnt work yet
	@PatchMapping("/users/{id}")
	public User updateUserPartially(@PathVariable int id, @RequestBody User u) {
		User user = retrieveUser(id);
		// assume that the update information form will show the existing user's information
		// otherwise will need to test if the field are null in order to not overwrite existing info
		// more complicated alternative: https://www.baeldung.com/spring-data-partial-update
		user.setCustomer_name(u.getCustomer_name());
		user.setAddress(u.getAddress());
		user.setEmail(u.getEmail());
		user.setLogin_password(u.getLogin_password());
		user.setSecret_question(u.getSecret_question());
		user.setTransaction_password(u.getTransaction_password());
		return user;
	}
	
}
