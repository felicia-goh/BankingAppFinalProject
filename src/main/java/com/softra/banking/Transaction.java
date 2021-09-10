package com.softra.banking;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="transactions")
public class Transaction {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private LocalDateTime txn_datetime;
	private String type;
	private double amount;
	private int account_id; // change this
	
	
	public Transaction(String description, LocalDateTime txn_datetime, String type, double amount, int account_id) {
		super();
		this.description = description;
		this.txn_datetime = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
		this.account_id = account_id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getTxn_datetime() {
		return txn_datetime;
	}

//	public void setTxn_datetime(LocalDateTime txn_datetime) {
//		this.txn_datetime = txn_datetime;
//	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", txn_datetime=" + txn_datetime + ", type="
				+ type + ", amount=" + amount + ", account_id=" + account_id + "]";
	}
	
}


