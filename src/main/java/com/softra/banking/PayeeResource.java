package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PayeeResource {
	
	@Autowired
	@Qualifier("payee") //jpa
	private IService<Payee> service;
	@Autowired
	@Qualifier("account")
	private IService<Account> accountService;
	
	public PayeeResource() {
	}
	
	@PostMapping(path = "/accounts/{account_id}/payees/new")
	public Payee save(@PathVariable(value = "account_id") int account_id, @RequestBody Payee payee) {
		
		Account acc = accountService.findById(account_id);
		Account payeeAcc = accountService.findById(payee.getPayee_account_id());
		
		if (acc.getId() != 0 && payeeAcc.getId() != 0) {
			payee.setAccount(acc);
			Payee p = service.save(payee);
			return p;
			
		} else {
			if (acc.getId() == 0) {
				System.out.println("Cannot find Account with id = " + account_id);
			} else if (payeeAcc.getId() == 0) {
				System.out.println("Cannot find Account with id = " + account_id + ", payee's account does not exist");
			}
			return null;
		}
	}
	
}
