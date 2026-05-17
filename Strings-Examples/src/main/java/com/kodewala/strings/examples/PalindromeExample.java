package com.kodewala.strings.examples;

public class PalindromeExample {

	public static void main(String[] args) {
		
	
	String str = "hello";
	
	StringBuffer s1 = new StringBuffer(str);
	if (str.equals(s1.reverse())) {
		System.out.println("This is palindrome");
	} else {
		System.out.println("This is not a Palindrome");
	}
	}
}
