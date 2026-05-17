package com.kodewala.streamsirbookexamples;

import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequencyOfCharacter {
	
	public static void main(String[] args) {
		String str = "bannana";
		
	Map<Character, Long> result	= str.chars().mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(result);
	}

}
