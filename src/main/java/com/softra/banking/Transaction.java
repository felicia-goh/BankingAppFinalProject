package com.softra.banking;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="transactions")
public class Transaction {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private LocalDateTime txn_datetime = LocalDateTime.now();
	private String type;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_transaction_id"))
	private Account account;
	
	public Transaction() {
		System.out.println("Inside default constructor of Transaction");
	}

	public Transaction(String description, LocalDateTime txn_datetime, String type, double amount, int account_id) {
		System.out.println("Inside parameterized constructor of Transaction");
		this.description = description;
		this.txn_datetime = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", txn_datetime=" + txn_datetime + ", type="
				+ type + ", amount=" + amount + ", account=" + account + "]";
	}
	
}


