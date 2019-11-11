package com.cg.ems.expenseclaim.dto;

public class Client {
	
	private int clientCode;
	
	
	private String clientName;

	private String clientCredibility;
	
	private String clientEmail;

	private String clientProjectName;

	
	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCredibility() {
		return clientCredibility;
	}

	public void setClientCredibility(String clientCredibility) {
		this.clientCredibility = clientCredibility;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientProjectName() {
		return clientProjectName;
	}

	public void setClientProjectName(String clientProjectName) {
		this.clientProjectName = clientProjectName;
	}

}