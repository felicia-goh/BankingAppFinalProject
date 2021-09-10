package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayeeJpaRepository extends IDao<Payee>, JpaRepository<Payee, Integer> {

}
