package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("payee")
public class PayeeService implements IService<Payee>{
	
	@Autowired
	@Qualifier("payeeJPA")
	private IDao<Payee> dao;
	
	public PayeeService() {
		System.out.println("inside userService default constructor");
	}
	
	@Override
	public List<Payee> findAll() {
		System.out.println("inside findAll of PayeeService");
		return dao.findAll();
	}

	@Override
	public Payee findById(int id) {
		System.out.println("inside findById of PayeeService");
		if (dao.findById(id).isPresent()) {
			return dao.findById(id).get();
		} else {
			return new Payee();
		}
	}

	@Override
	public Payee save(Payee user) {
		System.out.println("inside save of PayeeService");
		return dao.save(user);
	}

	@Override
	public Payee deleteById(int id) {
		System.out.println("inside deleteById of PayeeService");
		return dao.deleteById(id);
	}

}
