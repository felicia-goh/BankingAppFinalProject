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

import com.softra.banking.Exception.AccountNotFoundException;

@RestController
@CrossOrigin("*")
public class PayeeResource {
	
	@Autowired
	@Qualifier("payee") //jpa
	private IService<Payee> service;
	
	@Autowired
	@Qualifier("account")
	private IService<Account> accountService;
	
	public PayeeResource() {
	}
	
	@GetMapping(path = "/accounts/{account_id}/payees")
	public List<Payee> findAll(@PathVariable(value = "account_id") int account_id) throws AccountNotFoundException{
		
		return service.findByAccId(account_id);
		
	}
	
	@PostMapping(path = "/accounts/{account_id}/payees/new")
	public Payee save(@PathVariable(value = "account_id") int account_id, @RequestBody Payee payee) throws AccountNotFoundException {
		
		Account acc = accountService.findById(account_id);
		Account payeeAcc = accountService.findById(payee.getPayee_account_id());
		
		if (acc.getId() != 0 && payeeAcc.getId() != 0) {
			payee.setAccount(acc);
			Payee p = service.save(payee);
			return p;
			
		} else {
			if (acc.getId() == 0) {
				throw new AccountNotFoundException("Cannot find account with id = " + account_id);
			} else if (payeeAcc.getId() == 0) {
				throw new AccountNotFoundException("Cannot payee's account with id = " + account_id);
			}
			return null;
		}
	}
	
}
