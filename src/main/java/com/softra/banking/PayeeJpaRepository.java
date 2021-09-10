package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("payeeJPA")
public interface PayeeJpaRepository extends IDao<Payee>, JpaRepository<Payee, Integer> {

}
