package com.softra.banking;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="service_tracker")
public class ServiceRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	private int acctId;
	
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

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
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

	public ServiceRequest(int id, String description, int acctId, Date raisedDate) {
		super();
		this.id = id;
		this.description = description;
		this.acctId = acctId;
		this.raisedDate = raisedDate;
		this.status = "pending";
	}
	
	
	
	
	
	

}
