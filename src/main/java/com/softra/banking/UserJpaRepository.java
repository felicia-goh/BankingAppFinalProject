package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userJPA")
public interface UserJpaRepository extends IDao<User>, JpaRepository<User, Integer> {
	// Spring Data JPA
	// JpaRepository<Data type of Entity, datatype of Primary key>
	
}
