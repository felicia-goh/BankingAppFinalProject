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

import com.softra.banking.Exception.UserNotFoundException;

@RestController 				
@CrossOrigin("*")
public class AccountResource {
	
	@Autowired
	@Qualifier("account") //jpa
	private IService<Account> aservice;
	@Autowired
	@Qualifier("user")
	private IService<User> uservice;
	
	public AccountResource() {
		System.out.println("Inside default constructor of AccountResource");
	}
	
	@GetMapping(path = "/accounts")
	public List<Account> retrieveAllAccounts() {
		
		System.out.println("Inside retrieveAllAccounts of AccountResource");
		
		return aservice.findAll();
	}
	
	@GetMapping(path = "accounts/{account_id}")
	public Account retrieveAccount(@PathVariable(value = "account_id") int account_id) {
		System.out.println("Inside retrieveAccount of AccountResource");
		Account account = aservice.findById(account_id);
		if (account== null) {
			throw new UserNotFoundException("Account with id " + account_id + " not found");
		}
		return account;
	}
	
	@PostMapping(path = "/users/{user_id}/accounts/new")
	public Account save(@PathVariable(value = "user_id") int user_id, @RequestBody Account account) {
		
		System.out.println("Inside createAccount of AccountResource " + user_id);
		
		double balance = account.getBalance();
		
		if(balance < 100) {
			System.out.println("You must have a minimum of $100 to open an account with us");
			return null;			
		} else {
			User u = uservice.findById(user_id);
			System.out.println(u.getId());

			if (u.getId() != 0) {
				account.setUser(u);
				Account acc = aservice.save(account);
				return acc;
			} else {
				System.out.println("Cannot find User with id = " + user_id);
				return null;
			}
		}
	}
	
	@GetMapping(path = "/users/{user_id}/accounts")
	public List<Account> retrieveAllAccountsByUserId(@PathVariable(value = "user_id") int user_id) {
		
		System.out.println("Inside retrieveAllAccountsByUserId of AccountResource");
		
		return aservice.findByUserId(user_id);
	}
}
