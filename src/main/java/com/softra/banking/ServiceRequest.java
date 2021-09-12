package com.softra.banking;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;


@Entity(name="service_tracker")
public class ServiceRequest {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_service_id"))
	private Account account;

	private LocalDateTime raisedDate = LocalDateTime.now();
	
	private String status = "pending";
	
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

	public LocalDateTime getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(LocalDateTime raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", description=" + description + ", account=" + account + ", raisedDate="
				+ raisedDate + ", status=" + status + "]";
	}
	

}
