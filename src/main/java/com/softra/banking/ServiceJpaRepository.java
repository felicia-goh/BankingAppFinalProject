package com.softra.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("serviceJPA")
public interface ServiceJpaRepository extends IDao<ServiceRequest>, JpaRepository<ServiceRequest, Integer> {
	// Spring Data JPA
	// JpaRepository<Data type of Entity, datatype of Primary key>
	
}
