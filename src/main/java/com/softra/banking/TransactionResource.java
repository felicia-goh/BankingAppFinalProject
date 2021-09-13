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
import com.softra.banking.Exception.InsufficientFundsException;

@RestController
@CrossOrigin("*")
public class TransactionResource {
	
	@Autowired
	@Qualifier("transaction")
	private IService<Transaction> tservice;
	@Autowired
	@Qualifier("account")
	private IService<Account> aservice;
	
	public TransactionResource() {
		System.out.println("Inside default constructor of TransactionResource");
	}
	
	@GetMapping(path = "/accounts/{account_id}/transactions")
	public List<Transaction> findAll(@PathVariable(value = "account_id") int account_id) {
		
		System.out.println("Inside findAll of TransactionResource");
		
		return tservice.findByAccId(account_id);
	}
	
	@GetMapping(path = "/transactions")
	public List<Transaction> retrieveAllTransactions() {
		
		System.out.println("Inside retrieveAllTransactions of TrasactionResource");
		
		return tservice.findAll();
	}
	
	@PostMapping(path = "/accounts/{account_id}/transactions/new")
	public Transaction save(@PathVariable(value = "account_id") int account_id, @RequestBody Transaction transaction) throws InsufficientFundsException, AccountNotFoundException {
		
		System.out.println("Inside createTransaction of TransactionResource");
		
		double amount = transaction.getAmount();
		String type = transaction.getType();
		
		Account a = aservice.findById(account_id);
		System.out.println("Return account number: " + a.getId());
		
		if(a.getId() != 0) {
			transaction.setAccount(a);
			if(type.equals("withdraw")) {
				System.out.println("Current account balance: " + a.getBalance());
				if(amount > a.getBalance()) {
					throw new InsufficientFundsException("Insufficient funds to withdraw");
				} else {
					System.out.println("Withdrawing...");
					double balAfterWithdraw = a.getBalance() - amount;
					a.setBalance((float)balAfterWithdraw);
					System.out.println("Balance after withdraw: " + balAfterWithdraw);
					return tservice.save(transaction);
				}
			} else {
				System.out.println("Depositing...");
				double balAfterDeposit = a.getBalance() + amount;
				a.setBalance((float)balAfterDeposit);
				System.out.println("Balance after deposit: " + balAfterDeposit);
				return tservice.save(transaction);
			}		
		} else {
			throw new AccountNotFoundException("Cannot find Account with id = " + account_id);
		}
	}
}
