package com.softra.banking;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;





@Entity(name="service_tracker")
public class ServiceRequest {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	@OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	private Date raisedDate;
	
	private String status;
	
	/* -------- functions -------- */
	
	public ServiceRequest() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	// For jdbc template
	public ServiceRequest(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", description=" + description + ", account=" + account + ", raisedDate="
				+ raisedDate + ", status=" + status + "]";
	}
	


}
