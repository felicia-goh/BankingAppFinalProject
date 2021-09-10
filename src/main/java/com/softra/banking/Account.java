package com.softra.banking;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "accounts") // jpa
public class Account {

	@Id // jpa
	@GeneratedValue(strategy = GenerationType.AUTO) // jpa
	private int account_id;
	private String account_type;
	private float balance; 
	private Date open_date = new Date();
	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_account_id"))
	private User user;

	public Account() {
		System.out.println("Inside default constructor of Account");
	}

	public Account(int id, String account_type, float balance, int user_id) {
		System.out.println("Inside parameterized constructor of Account");

		this.account_id = id;
		this.account_type = account_type;
		this.balance = balance;
	}

	public int getId() {
		return account_id;
	}

	public void setId(int id) {
		this.account_id = id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
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
		return "Account [account_id=" + account_id + ", account_type=" + account_type + ", balance=" + balance
				+ ", open_date=" + open_date + ", user=" + user + "]";
	}

}
