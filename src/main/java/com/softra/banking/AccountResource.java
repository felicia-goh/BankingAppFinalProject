package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 																// return type will be in json format
@CrossOrigin("*")
public class AccountResource {
	
	@Autowired
	@Qualifier("account") //jpa
	private IService<Account> service;
	@Autowired
	@Qualifier("user")
	private IService<User> uservice;
	
	public AccountResource() {
		System.out.println("Inside default constructor of AccountResource");
	}
	
	@PostMapping(path = "/users/{user_id}/accounts/new")
	public Account save(@PathVariable(value = "user_id") int user_id, @RequestBody Account account) {
		
		System.out.println("Inside createAccount of AccountResource " + user_id);
		
		float balance = account.getBalance();
		
		if(balance < 100) {
			System.out.println("You must have a minimum of $100 to open an account with us");
			return null;			
		} else {
			System.out.println("inside test");
			User u = uservice.findById(user_id);
			System.out.println(u.getId());

			if (u.getId() != 0) {
				account.setUser(u);
				Account acc = service.save(account);
				return acc;
			} else {
				System.out.println("Cannot find User with id = " + user_id);
				return null;
			}
		}
	}
	
	
	@GetMapping(path = "/accounts")
	public List<Account> findAll() {
		
		System.out.println("Inside retrieveAllAccounts of AccountResource");
		
		return service.findAll();
	}
}
