package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("account")
public class AccountService implements IService<Account> {
	
	@Autowired
	@Qualifier("accountJPA") //jpa
	private IDao<Account> dao;

	public AccountService() {
		System.out.println("Inside default constructor of AccountService");
	}

	@Override
	public Account save(Account account) {
		System.out.println("Inside createAccount of AccountService " + account);
		
		return dao.save(account);
	}

	@Override
	public List<Account> findAll() {		
		System.out.println("Inside retrieveAllAccounts of AccountResource");
		
		return dao.findAll();
	}

	@Override
	public Account findById(int id) {
		System.out.println("Inside findById of AccountService");
		if (dao.findById(id).isPresent()) {
			return dao.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Account deleteById(int id) {
		
		return null;
	}
	
	@Override
	public List<Account> findByUserId(int id) {
		System.out.println("Inside findByUserId of AccountService");
		
		return dao.findByUserId(id);
	}

	@Override
	public List<Account> findByAccId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
