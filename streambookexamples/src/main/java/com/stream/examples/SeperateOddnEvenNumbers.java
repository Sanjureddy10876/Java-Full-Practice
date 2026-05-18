package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, separate odd and even numbers?
public class SeperateOddnEvenNumbers {
	public static void main(String[] args) {
		
		List<Integer> str = Arrays.asList(1,2,3,4,5,6,7,8,9);
	List<Integer>	evenNumbers = str.stream().filter(n -> n % 2 ==0).collect(Collectors.toList());
	List<Integer> oddNumbers = str.stream().filter(n -> n % 2 !=0).collect(Collectors.toList());
	System.out.println("Even Numbers "+evenNumbers+" "+"Odd Numbers"+oddNumbers);
	}

}
