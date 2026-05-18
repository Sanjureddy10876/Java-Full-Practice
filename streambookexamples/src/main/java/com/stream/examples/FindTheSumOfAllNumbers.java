package com.stream.examples;

import java.util.Arrays;
import java.util.List;

//Find sum of all digits of a number in Java 8?
public class FindTheSumOfAllNumbers {

	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(34,65,98,34);
	int result	=str.stream().mapToInt(n -> n).sum();
	System.out.println(result);
		
		
	}
}
