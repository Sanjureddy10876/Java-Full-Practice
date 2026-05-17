package com.kodewala.strings.examples;

public class Example1 {
	
	public static void main(String[] args) {
		String s1 = "kodewala";
		String s2 = "Kodewala";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.indexOf("s"));
		System.out.println(s1.lastIndexOf("l"));
		System.out.println(s1.substring(5));
		System.out.println(s1.substring(0, 5));
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toUpperCase().equals(s2.toUpperCase()));
		System.out.println(s1.toLowerCase());
		String s3 = "   kodewala    ";
		System.out.println(s3.trim());
		System.out.println(s3.replace("a", "e").trim());
		
	}

}
