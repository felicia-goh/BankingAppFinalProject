package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("transactionJPA")
public interface TransactionJpaRepository extends IDao<Transaction>, JpaRepository<Transaction, Integer> {

}
