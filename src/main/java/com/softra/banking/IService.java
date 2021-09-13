package com.softra.banking;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface IService<T> {


	public T findById(int id);
	public List<T> findAll();
	public T save(T entity);
	public T deleteById(int id);
//	@Query("from accounts where user_id = :id")
	public List<T> findByUserId(int id);
//	@Query("from transactions where account_id = :id")
	public List<T> findByAccId(int id);
}
