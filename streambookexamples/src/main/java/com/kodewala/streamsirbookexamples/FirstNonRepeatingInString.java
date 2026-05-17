package com.kodewala.streamsirbookexamples;

public class FirstNonRepeatingInString {
	public static void main(String[] args) {
		String str = "swiss";
	
	Character result =str.chars().mapToObj(c -> (char) c)
		.filter(n -> str.indexOf(n)==str.lastIndexOf(n)).findFirst().orElse(null);
		System.out.println(result);
	}

}
