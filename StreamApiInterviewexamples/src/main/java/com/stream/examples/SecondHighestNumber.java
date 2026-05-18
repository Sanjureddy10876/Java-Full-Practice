package com.stream.examples;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find the second highest number using Java Streams.
public class SecondHighestNumber {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10, 45, 32, 67, 89, 67, 89, 23);

		Integer result = nums.stream().sorted((a, b) -> b - a).distinct().skip(1).findFirst().get();
		System.out.println(result);
	}

}
