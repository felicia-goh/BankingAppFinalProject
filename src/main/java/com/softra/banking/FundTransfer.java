package com.softra.banking;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "fund_transfers")
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fund_transfer_id;
	private int payee_id;
	private int sender_transaction_id; // or Transaction?
	private int payee_transaction_id;
	private double amount;
	// txn datetime will be created in txn so won't duplicate here
	@ManyToOne
	@JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_fund_transfer_id"))
	private Account account;
	
	public FundTransfer() {
		super();
	}
	
	public FundTransfer(int payee_id, double amount) {
		super();
		this.payee_id = payee_id;
		this.amount = amount;
	}

	public int getPayee_id() {
		return payee_id;
	}

	public void setPayee_id(int payee_id) {
		this.payee_id = payee_id;
	}

	public int getSender_transaction_id() {
		return sender_transaction_id;
	}

	public void setSender_transaction_id(int sender_transaction_id) {
		this.sender_transaction_id = sender_transaction_id;
	}

	public int getPayee_transaction_id() {
		return payee_transaction_id;
	}

	public void setPayee_transaction_id(int payee_transaction_id) {
		this.payee_transaction_id = payee_transaction_id;
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
		return "FundTransfer [fund_transfer_id=" + fund_transfer_id + ", payee_id=" + payee_id
				+ ", sender_transaction_id=" + sender_transaction_id + ", payee_transaction_id=" + payee_transaction_id
				+ ", amount=" + amount + ", account=" + account + "]";
	}
	
	
}
