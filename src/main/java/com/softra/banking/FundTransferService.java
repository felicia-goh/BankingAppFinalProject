package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fundTransfer")
public class FundTransferService implements IService<FundTransfer>{
	
	@Autowired
	@Qualifier("payeeJPA")
	private IDao<FundTransfer> dao;
	
	public FundTransferService() {
		System.out.println("inside userService default constructor");
	}
	
	@Override
	public List<FundTransfer> findAll() {
		System.out.println("inside findAll of FundTransferService");
		return dao.findAll();
	}

	@Override
	public FundTransfer findById(int id) {
		System.out.println("inside findById of FundTransferService");
		if (dao.findById(id).isPresent()) {
			return dao.findById(id).get();
		} else {
			return new FundTransfer();
		}
	}

	@Override
	public FundTransfer save(FundTransfer user) {
		System.out.println("inside save of FundTransferService");
		return dao.save(user);
	}

	@Override
	public FundTransfer deleteById(int id) {
		System.out.println("inside deleteById of FundTransferService");
		return dao.deleteById(id);
	}

}
