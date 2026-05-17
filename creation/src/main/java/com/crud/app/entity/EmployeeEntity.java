package com.crud.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_info")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private int age;
	private String jobRole;
	private String skinclr;
	public Long getId() {
		return id;
	}
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
	public void setId(Long id) {
		this.id = id;
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
