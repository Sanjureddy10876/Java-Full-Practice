package com.stream.examples;

public class NonRepeatingCharacter {
	public static void main(String[] args) {
		String str = "aabbcddeff";

		Character result = str.chars().mapToObj(c -> (char) c).filter(n -> str.indexOf(n) == str.lastIndexOf(n))
				.findFirst().orElse(null);
		System.out.println(result);
	}

}
