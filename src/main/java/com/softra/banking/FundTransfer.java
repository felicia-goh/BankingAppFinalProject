package com.softra.banking;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "fund_transfers")
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fund_transfer_id;
	private int payee_id;
	@OneToOne
	@JoinColumn(name = "sender_transaction_id", foreignKey = @ForeignKey(name = "fk_sender_transaction_fund_transfer_id"))
	private Transaction sender_transaction; // or Transaction?
	@OneToOne
	@JoinColumn(name = "payee_transaction_id", foreignKey = @ForeignKey(name = "fk_payee_transaction_fund_transfer_id"))
	private Transaction payee_transaction;
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

	public int getFund_transfer_id() {
		return fund_transfer_id;
	}

	public Transaction getSender_transaction() {
		return sender_transaction;
	}

	public void setSender_transaction(Transaction sender_transaction) {
		this.sender_transaction = sender_transaction;
	}

	public Transaction getPayee_transaction() {
		return payee_transaction;
	}

	public void setPayee_transaction(Transaction payee_transaction) {
		this.payee_transaction = payee_transaction;
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
		return "FundTransfer [fund_transfer_id=" + fund_transfer_id + ", payee_id=" + payee_id + ", sender_transaction="
				+ sender_transaction + ", payee_transaction=" + payee_transaction + ", amount=" + amount + ", account="
				+ account + "]";
	}
	
}
