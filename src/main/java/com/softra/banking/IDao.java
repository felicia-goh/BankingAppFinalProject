package com.softra.banking;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
	
//	public List<Customer> findAll();
//	public Optional<Customer> findById(int id);
//	public Customer save(Customer user);
//	public Customer deleteById(int id);
//	public List<Customer> findByIdOrName(int id, String name);
	
	public List<T> findAll();
	public Optional<T> findById(int id);
	public T save(T entity);
	public T deleteById(int id);
	
	// Hi, Jinnee here!
}
