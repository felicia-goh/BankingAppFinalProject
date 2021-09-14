package com.softra.banking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// creates table called users
@Entity(name = "users")
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String customer_name;
	private String email;
	private String address;
	private String pancard;
	private String login_password;
	private String secret_question;
	private String transaction_password;
	private boolean lock_status = false;
	private boolean isAdmin = false;

	public User() {
		super();
	}
	
	public User(String email, String login_password) {
		super();
		this.email = email;
		this.login_password = login_password;
	}

	public User(int id, String login_password) {
		super();
		this.id = id;
		this.login_password = login_password;
	}

	public User(String login_password, String secret_question, String transaction_password) {
		super();
		this.login_password = login_password;
		this.secret_question = secret_question;
		this.transaction_password = transaction_password;
		this.lock_status = false;
		this.isAdmin = false;
	}

	public User(String customer_name, String email, String address, String pancard, String login_password,
			String secret_question, String transaction_password) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.login_password = login_password;
		this.secret_question = secret_question;
		this.transaction_password = transaction_password;
		this.lock_status = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	public String getSecret_question() {
		return secret_question;
	}

	public void setSecret_question(String secret_question) {
		this.secret_question = secret_question;
	}

	public String getTransaction_password() {
		return transaction_password;
	}

	public void setTransaction_password(String transaction_password) {
		this.transaction_password = transaction_password;
	}

	public boolean isLock_status() {
		return lock_status;
	}

	public void setLock_status(boolean lock_status) {
		this.lock_status = lock_status;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", customer_name=" + customer_name + ", email=" + email + ", address=" + address
				+ ", pancard=" + pancard + ", login_password=" + login_password + ", secret_question=" + secret_question
				+ ", transaction_password=" + transaction_password + ", lock_status=" + lock_status + ", isAdmin="
				+ isAdmin + "]";
	}

}
