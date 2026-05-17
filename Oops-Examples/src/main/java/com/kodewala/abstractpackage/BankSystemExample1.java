package com.kodewala.abstractpackage;
abstract class Account {
	double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	abstract void caluculateintrest();
	void showBalanace() {
		System.out.println("Current balance"+balance);
		System.out.println("Current balance"+balance);
	}
}

class SavingsAccount extends Account{

	double intrestRate = 5.0;
	
	public SavingsAccount(double balance) {
		super(balance);
		
	}

	@Override
	void caluculateintrest() {
		
		double intrest =(balance * intrestRate);
		balance += intrest;
		System.out.println("intrest added "+intrest);
	}
	
}

class CurrentAccount extends Account{

	public CurrentAccount(double balance) {
		super(balance);
		
	}
	
	@Override
	void caluculateintrest() {
		System.out.println("No intrest for Current Account");
	}
}

public class BankSystemExample1 {
	public static void main(String[] args) {
		Account saving  = new SavingsAccount(100);
		saving.showBalanace();
		saving.caluculateintrest();
		saving.showBalanace();
		
		Account current = new CurrentAccount(2000);
		current.showBalanace();
		current.caluculateintrest();
		current.showBalanace();
	}

}
