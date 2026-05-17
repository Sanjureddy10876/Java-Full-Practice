package com.kodewala.bean;

public class Company {

	private String name;
	private String details;
	
	
	public Company(String name, String details) {
		super();
		this.name = name;
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
