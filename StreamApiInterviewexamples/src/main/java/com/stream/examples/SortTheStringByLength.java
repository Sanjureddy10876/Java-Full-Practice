package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of strings, sort them according to increasing order of their length?
public class SortTheStringByLength {
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("laptop", "chair", "kodewala");

		List<String> result = arr.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
		System.out.println(result);
	}

}
