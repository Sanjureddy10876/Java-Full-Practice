package com.kodewala.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Account {
	
	private String name;
	private String type;
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	// 1. Constructor
	public Account(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	// 2. Setter (optional - only if used)
		public void setName(String name) {
			System.out.println("2. Setter called");
			this.name = name;
		}

	//3. @PostConstruct - Post bean construction
	@PostConstruct
	public void init() {
		System.out.println("3. @PostConstruct called");
	}
	
	//4. Bussiness method
	public void print() {
		System.out.println("4. Bean Ready  " + name + " | " + type);
	}
	
	//5. @preDestory
	@PreDestroy
	public void preDestroy() {
		System.out.println("6. @PreDestroy called");
	}

}
