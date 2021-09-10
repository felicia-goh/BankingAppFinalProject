package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountJPA")
public interface AccountJpaRepository extends IDao<Account>, JpaRepository<Account, Integer> {

}
