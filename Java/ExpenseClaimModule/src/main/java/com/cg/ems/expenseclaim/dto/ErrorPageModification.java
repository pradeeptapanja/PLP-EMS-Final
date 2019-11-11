package com.cg.ems.expenseclaim.dto;

import java.util.Date;

public class ErrorPageModification {
private Date timestamp;
	
	private String message;
	
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

