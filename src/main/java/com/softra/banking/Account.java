package com.softra.banking;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "accounts") // jpa
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String account_type;
	private double balance;
	private LocalDateTime open_date = LocalDateTime.now();
	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_account_id"))
	private User user;

	public Account() {
		System.out.println("Inside default constructor of Account");
	}

	public Account(int id, String account_type, double balance, int user_id) {
		System.out.println("Inside parameterized constructor of Account");

		this.id = id;
		this.account_type = account_type;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getOpen_date() {
		return open_date;
	}

	public void setOpen_date(LocalDateTime open_date) {
		this.open_date = open_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account_type=" + account_type + ", balance=" + balance
				+ ", open_date=" + open_date + ", user=" + user + "]";
	}

}
