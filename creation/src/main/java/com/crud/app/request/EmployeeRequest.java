package com.crud.app.request;


public class EmployeeRequest {

	private String name;
	private String description;
	private int age;
	private String jobRole;
	private String skinclr;
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getAge() {
		return age;
	}
	public String getJobRole() {
		return jobRole;
	}
	public String getSkinclr() {
		return skinclr;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public void setSkinclr(String skinclr) {
		this.skinclr = skinclr;
	}
	
	
}
