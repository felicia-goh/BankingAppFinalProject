package com.softra.banking.Exception;

import java.util.Date;

public class CustomExceptionResponse {
	private Date timestamp;
	private String msg;
	private String detailedMsg;
	
	public CustomExceptionResponse(Date timestamp, String msg, String detailedMsg) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
		this.detailedMsg = detailedMsg;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetailedMsg() {
		return detailedMsg;
	}

	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}
	
	
	
}
