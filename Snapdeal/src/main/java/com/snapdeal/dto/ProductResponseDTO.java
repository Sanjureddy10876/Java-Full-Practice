package com.snapdeal.dto;

public class ProductResponseDTO {
	private int id;
	private String confirmMsg;
	
	
	public ProductResponseDTO() {
		
	}


	public ProductResponseDTO(int id, String confirmMsg) {
		super();
		this.id = id;
		this.confirmMsg = confirmMsg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getConfirmMsg() {
		return confirmMsg;
	}


	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	
	

}
