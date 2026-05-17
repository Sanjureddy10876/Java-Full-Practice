package com.kodewala.polymorphism;

class Account {
	void useraccount(int max) {
		System.out.println("Inside the account ");
	}
}

class User extends Account{
	
	@Override
	void useraccount(int max) {
		System.out.println("Inside the user account");
	}
}

public class MethodOveriding {

	public static void main(String[] args) {
		User s1 = new User();
		s1.useraccount(200);
		Account c1 = new Account();
		c1.useraccount(1000);
		Account c2 = new User();
		c2.useraccount(20000);
	}
}
