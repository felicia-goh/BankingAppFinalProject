package com.softra.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.banking.Exception.AccountNotFoundException;
import com.softra.banking.Exception.InsufficientFundsException;
import com.softra.banking.Exception.PayeeNotFoundException;

@RestController
@CrossOrigin("*")
public class FundTransferResource {
	
	@Autowired
	@Qualifier("fundTransfer")
	private IService<FundTransfer> service;
	
	@Autowired
	@Qualifier("account")
	private IService<Account> accountService;
	
	@Autowired
	@Qualifier("payee")
	private IService<Payee> payeeService;
	
	@Autowired
	@Qualifier("transaction")
	private IService<Transaction> transactionService;
	
	public FundTransferResource() {
	}
	
	@PostMapping(path = "/accounts/{account_id}/fund_transfers/new")
	public FundTransfer save(@PathVariable(value = "account_id") int account_id, @RequestBody FundTransfer fundTransfer) throws AccountNotFoundException, PayeeNotFoundException, InsufficientFundsException {
		
		Account acc = accountService.findById(account_id);
		Payee payee = payeeService.findById(fundTransfer.getPayee_id());
		Account payeeAcc = accountService.findById(payee.getPayee_account_id());
		double amt = fundTransfer.getAmount();
		
		if (acc.getId() != 0 && payee.getPayee_id() != 0) {
			
			if (acc.getBalance() >= amt) {
				fundTransfer.setAccount(acc);
				
				Transaction senderTxn = new Transaction("fund transfer", "withdraw", amt);
				senderTxn.setAccount(acc);
				acc.setBalance(acc.getBalance() - amt); // ideally this logic should be in transactions
				Transaction senderTransaction = transactionService.save(senderTxn);
				fundTransfer.setSender_transaction(senderTransaction);
				
				
				Transaction payeeTxn = new Transaction("fund transfer", "deposit", amt);
				payeeTxn.setAccount(payeeAcc);
				payeeAcc.setBalance(payeeAcc.getBalance() + amt); // ideally this logic should be in transactions
				Transaction payeeTransaction = transactionService.save(payeeTxn);
				fundTransfer.setPayee_transaction(payeeTransaction);
				
				FundTransfer ft = service.save(fundTransfer);
				return ft;
			} else {
				throw new InsufficientFundsException("Insufficient funds to transfer");
			}
			
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
