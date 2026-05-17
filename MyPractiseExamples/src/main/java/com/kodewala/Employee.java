package com.kodewala;

//
//❓ Problem
//
//Create your own immutable class.
public class Employee {

	private  int id;
	private  String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name=name;
	}
	
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
