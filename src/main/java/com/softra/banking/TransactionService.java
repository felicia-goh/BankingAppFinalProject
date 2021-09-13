package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("transaction")
public class TransactionService implements IService<Transaction> {
	
	@Autowired
	@Qualifier("transactionJPA")
	private IDao<Transaction> dao;
	
	public TransactionService() {
		System.out.println("Inside default constructor of TransactionService");
	}

	@Override
	public Transaction findById(int id) {
		
		return null;
	}

	@Override
	public List<Transaction> findAll() {
		System.out.println("Inside findAll of TransactionService");
		return dao.findAll();
	}

	@Override
	public Transaction save(Transaction transaction) {
		System.out.println("Inside save of TransactionService");
		return dao.save(transaction);
	}

	@Override
	public Transaction deleteById(int id) {
		
		return null;
	}

	@Override
	public List<Transaction> findByUserId(int id) {
		
		return null;
	}

	@Override
	public List<Transaction> findByAccId( int accId) {
		
		System.out.println("Inside findByUserAccId of TransactionService");
		List<Transaction> tlist = dao.findByAccId(accId);
		System.out.println(tlist);
		return tlist;
	}

}
