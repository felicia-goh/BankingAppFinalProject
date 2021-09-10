package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.AccountNotFoundException;
import com.softra.banking.Exception.PayeeNotFoundException;

@RestController
public class FundTransferResource {
	
	@Autowired
	@Qualifier("fundTransfer") //jpa
	private IService<FundTransfer> service;
	
	@Autowired
	@Qualifier("account")
	private IService<Account> accountService;
	
	@Autowired
	@Qualifier("payee")
	private IService<Payee> payeeService;
	
	public FundTransferResource() {
	}
	
	@PostMapping(path = "/accounts/{account_id}/fund_transfers/new")
	public FundTransfer save(@PathVariable(value = "account_id") int account_id, @RequestBody FundTransfer fundTransfer) throws AccountNotFoundException, PayeeNotFoundException {
		
		Account acc = accountService.findById(account_id);
		Payee payee = payeeService.findById(fundTransfer.getPayee_id());
		
		if (acc.getId() != 0 && payee.getPayee_id() != 0) {
			fundTransfer.setAccount(acc);
			FundTransfer ft = service.save(fundTransfer);
			return ft;
			
		} else {
			if (acc.getId() == 0) {
				throw new AccountNotFoundException("Cannot find account with id = " + account_id);
			} else if (payee.getPayee_id() == 0) {
				throw new PayeeNotFoundException("Cannot payee with id = " + payee.getPayee_id() + ", please add payee first");
			}
			return null;
		}
	}
	
}
