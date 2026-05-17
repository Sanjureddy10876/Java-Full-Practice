package com.kodewala.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class Employe {
	private String name;
	
	private Address addressConstructor;
	private Address addressSetter;

	//Field Injection (this is not preffered in industry)
	@Autowired
	private Address addresField;
	
	
	//Constructor Injection
	public Employe(Address __address) {
		this.addressConstructor = __address;
		this.name = "Constructor Employee";
	}
	
	//Setter Injection
	@Autowired
	public void SetAddressSetter(Address addressSetter) {
		this.addressSetter = addressSetter;
	}


	public void getEmployeeDetails() {
		//Constructor Injection
		System.out.println("-- Constructor Injection --");
		System.out.println("Name : "+name);
		System.out.println("Address : "+addressConstructor.getCity()+" "+addressConstructor.getState());
		
		//Setter Injection
		System.out.println("-- Setter Injection --");
		System.out.println("Name : Setter Employee");
		System.out.println("Address : "+addressSetter.getCity()+", "+addressSetter.getState());
		
		//Field Injection (this is not preffered in industry)
		
		System.out.println("-- Field Injection --");
		System.out.println("Address : "+addresField.getCity()+","+addresField.getState());
		
	}
	

}
