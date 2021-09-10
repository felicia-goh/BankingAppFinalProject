package com.softra.banking;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
	
	public List<T> findAll();
	public Optional<T> findById(int id);
	public T save(T entity);
	public T deleteById(int id);
	
}
