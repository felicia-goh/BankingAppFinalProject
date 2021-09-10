package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PayeeResource {
	
	@Autowired
	@Qualifier("account") //jpa
	private IService<Payee> service;
	@Autowired
	@Qualifier("user")
	private IService<Account> uservice;
	
	public PayeeResource() {
	}
	
	@PostMapping(path = "/users/{user_id}/payees/new")
	public Payee save(@PathVariable(value = "user_id") int user_id, @RequestBody Payee payee) {
		

			Account u = uservice.findById(user_id);

			if (u.getId() != 0) {
				payee.setAccount(u);
				Payee p = service.save(payee);
				return p;
			} else {
				System.out.println("Cannot find Account with id = " + user_id);
				return null;
			}
		}
}
