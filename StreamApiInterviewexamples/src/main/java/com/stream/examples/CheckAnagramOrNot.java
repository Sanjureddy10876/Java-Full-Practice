package com.stream.examples;

import java.util.stream.Collectors;

//Java 8 program to check if two strings are anagrams or not?
public class CheckAnagramOrNot {
	public static void main(String[] args) {
		String str = "hello";
		String str1 = "hello";

		char[] resana1 = str.toCharArray();
		char[] resana2 = str1.toCharArray();
		
		

		String res1 = str.chars().mapToObj(c -> (char) c).sorted().map(String::valueOf).collect(Collectors.joining());
		String res2 = str1.chars().mapToObj(c -> (char) c).sorted().map(String::valueOf).collect(Collectors.joining());

		if (res1.equalsIgnoreCase(res2)) {
			System.out.println("It is anagram");
		} else {
			System.out.println("It is not an anagram");
		}
	}

}
