package com.softra.banking;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "payees")
public class Payee {
	
	@Id // jpa
	@GeneratedValue(strategy = GenerationType.AUTO) // jpa
	private int payee_id;
	private int payee_account_id;
	private String nickname;
	@ManyToOne
	@JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_payee_id"))
	private Account account;
	
	public Payee() {
		super();
	}

	public Payee(int payee_account_id, String nickname) {
		super();
		this.payee_account_id = payee_account_id;
		this.nickname = nickname;
	}
	
	public int getPayee_account_id() {
		return payee_account_id;
	}
	
	public void setPayee_account_id(int payee_account_id) {
		this.payee_account_id = payee_account_id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Payee [payee_id=" + payee_id + ", payee_account_id=" + payee_account_id + ", nickname=" + nickname
				+ ", account=" + account + "]";
	}
	
	
}
