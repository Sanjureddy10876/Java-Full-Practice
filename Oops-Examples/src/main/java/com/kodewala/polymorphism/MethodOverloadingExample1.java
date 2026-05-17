package com.kodewala.polymorphism;

class Registration {
	void doRegistraction(String aadhar) {
		System.out.println("Register using aadhar "+aadhar);
	}
	void doRegistraction(int aadharnum, String aadharName) {
		System.out.println("Register using num and name "+ aadharnum + aadharName);
	}
	
	void doRegistraction(int aadarnum, int pincode, String name) {
		System.out.println("Reg using num & pincode & name "+ aadarnum +pincode + name);
	}
}

public class MethodOverloadingExample1 {

	public static void main(String[] args) {
		Registration reg = new Registration();
		reg.doRegistraction("Reddy");
		reg.doRegistraction(21, "Reddy");
		reg.doRegistraction(21, 1000, "Reddy");
	}
}
