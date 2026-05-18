package com.stream.examples;

import java.util.Arrays;
import java.util.List;


//Given a list of integers, find maximum and minimum of those numbers?
public class FindTheMaxnMinOfNumbers {
	public static void main(String[] args) {
		List<Integer> str1 = Arrays.asList(2, 5, 3, 1);

	Integer minVal	=str1.stream().min(Integer::compare).get();
	Integer maxVal	=str1.stream().max((a,b) -> a-b).get();
	System.out.println("Maximum Value is "+maxVal+" Minimum Value is "+minVal);	
	
	}
	
}
