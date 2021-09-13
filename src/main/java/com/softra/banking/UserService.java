package com.softra.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// meta-annotation: similar to @Component but more specific
@Service("user")
public class UserService implements IService<User> {
	
	@Autowired
	@Qualifier("userJPA")
	private IDao<User> dao;
	
	public UserService() {
		System.out.println("inside userService default constructor");
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("inside findAll of UserService");
		return dao.findAll();
	}

	@Override
	public User findById(int id) {
		System.out.println("inside findById of UserService");
		if (dao.findById(id).isPresent()) {
			return dao.findById(id).get();
		} else {
			return new User();
		}
	}

	@Override
	public User save(User user) {
		System.out.println("inside save of UserService");
		return dao.save(user);
	}

	@Override
	public User deleteById(int id) {
		System.out.println("inside deleteById of UserService");
		return dao.deleteById(id);
	}

	@Override
	public List<User> findByUserId(int id) {
		
		return null;
	}

	@Override
	public List<User> findByAccId(int id) {
		
		return null;
	}
}
