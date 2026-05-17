package com.kodewala.encapsulation;

class BankAccount {
	private double balance;
	public BankAccount(double balance) {
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		if (amount <0) {
			balance +=balance;
			System.out.println("Deposited "+amount);
		}
		else {
			System.out.println("Invalid amount");
		}
		
	}
	public void withdraw(double amount) {
		if (amount > 0 && amount<=balance ) {
			balance-=amount;
			System.out.println("withdraw "+amount);
		}
		else {
			System.out.println("invalid");
		}
	}
}

public class Example1 {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount(1000);
		b1.deposit(500);
		b1.withdraw(200);
		System.out.println("final balance "+b1.getBalance());
	}
}
