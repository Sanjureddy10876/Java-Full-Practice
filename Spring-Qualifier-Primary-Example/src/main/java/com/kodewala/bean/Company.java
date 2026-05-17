package com.kodewala.bean;

public class Company {
	private String companyName;
	private int companyId;
	
	public Company(String companyName, int companyId)
	{
		this.companyId = companyId;
		this.companyName= companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	

}
