package com.stream.examples;

import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequencyofEachCharacter {
	public static void main(String[] args) {
		String str = "java";
		Map<Character, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(result);
	}
}
