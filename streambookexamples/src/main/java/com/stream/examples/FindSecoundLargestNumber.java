package com.stream.examples;

import java.util.Arrays;
import java.util.List;

//Find second largest number in an integer array?
public class FindSecoundLargestNumber {
	public static void main(String[] args) {
		//method 1
		int[] arr = { 45, 35, 92, 1, 65, 98 };
		int result = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).skip(1).findFirst().get();
		System.out.println(result);

		//method 2 
		List<Integer> arr1 = Arrays.asList(45, 35, 92, 1, 65, 98);
		Integer result1 = arr1.stream().sorted((a, b) -> b - a).skip(1).findFirst().get();
		System.out.println(result1);
	}

}
