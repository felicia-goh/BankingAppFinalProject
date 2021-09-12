package com.softra.banking;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

public interface CustomDao {
	
	@Query("from accounts where user_id = :id")
	public List<Account> findByUserId(int id);
	@Query("from transactions where account_id = :id")
	public List<Transaction> findByAccId(int id);

}
