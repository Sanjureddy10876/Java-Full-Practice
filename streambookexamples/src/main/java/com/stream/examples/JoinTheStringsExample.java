package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
public class JoinTheStringsExample {
	public static void main(String[] args) {
	
		List<String> str = Arrays.asList("Table","Chair","Laptop","Mouse");
		String	result = str.stream().collect(Collectors.joining(",","[","]"));
		System.out.println(result);
	}

}
