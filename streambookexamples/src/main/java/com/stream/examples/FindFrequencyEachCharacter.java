package com.stream.examples;

import java.util.Map;
import java.util.stream.Collectors;

//How do you find frequency of each character in a string using Java 8 streams?
public class FindFrequencyEachCharacter {
	public static void main(String[] args) {
		String str = "siwss";

		Map<Character, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(h -> h, Collectors.counting()));
		System.out.println(result);
	}

}
