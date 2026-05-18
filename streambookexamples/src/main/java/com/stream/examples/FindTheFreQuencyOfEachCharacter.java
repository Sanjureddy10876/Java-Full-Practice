package com.stream.examples;

import java.util.Map;
import java.util.stream.Collectors;

//How do you find frequency of each element in an array or a list?
public class FindTheFreQuencyOfEachCharacter {
	public static void main(String[] args) {
		String str = "siwss";
		
		Map<Character, Long> max	=str.chars().mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(c -> c,Collectors.counting()));
	System.out.println(max);
	}

}
