package com.nothing.dto;

public class PhoneResponse {

	private Long id;
	private String confirmmsg;

	public PhoneResponse() {
		
	}

	public PhoneResponse(Long id, String confirmmsg) {
		super();
		this.id = id;
		this.confirmmsg = confirmmsg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmmsg() {
		return confirmmsg;
	}

	public void setConfirmmsg(String confirmmsg) {
		this.confirmmsg = confirmmsg;
	}

	
	
}
