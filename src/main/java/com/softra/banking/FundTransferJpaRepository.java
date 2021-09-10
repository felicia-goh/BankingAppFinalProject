package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fundTransferJPA")
public interface FundTransferJpaRepository extends IDao<FundTransfer>, JpaRepository<FundTransfer, Integer> {

}
