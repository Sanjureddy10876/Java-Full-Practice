package com.kodewala;

public class Palindrome {
	
	public static void main(String[] args) {
		String str = "Testing";
		
		String stringBuilder = new StringBuilder(str).reverse().toString();
		
		if (str.equals(stringBuilder)) {
			System.out.println("Its is palimdrome");
		}
		 else {
			System.out.println("it is not palimdrome");
		}
	}

}
