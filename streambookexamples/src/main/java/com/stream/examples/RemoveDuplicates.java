package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//How do you remove duplicate elements from a list using Java 8 streams
public class RemoveDuplicates {
	
	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(21,31,4,51,61,71,31,21,91);

	List<Integer> result = str.stream().distinct().collect(Collectors.toList());
	System.out.println(result);
	
	
	}
	
		
}
