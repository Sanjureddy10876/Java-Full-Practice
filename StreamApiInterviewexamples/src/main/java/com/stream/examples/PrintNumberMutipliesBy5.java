package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//From the given list of integers, print the numbers which are multiples of 5?
public class PrintNumberMutipliesBy5 {
	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(1, 6, 75, 25, 89, 30);
		List<Integer> result = str.stream().filter(n -> n % 5 == 0).collect(Collectors.toList());
		System.out.println(result);
	}

}
