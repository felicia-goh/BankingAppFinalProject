package com.softra.banking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// just for testing the Service features
// can delete if the account features has developed
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public Account() {}
	
	public Account(int id) {
		this.id = id;
	}

}
