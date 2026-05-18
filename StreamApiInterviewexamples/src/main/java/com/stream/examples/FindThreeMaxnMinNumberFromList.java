package com.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//How do you get three maximum numbers and three minimum numbers from the given list of integers?
public class FindThreeMaxnMinNumberFromList {
	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(6, 32, 8, 1, 73, 9);
		List<Integer> max = str.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		List<Integer> min = str.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());
		System.out.println("Maximum::" + max + " " + "Minimum::" + min);

		//another type of answer
//		Optional<Integer> min1 = str.stream().min((a, b) -> a - b);
//		Optional<Integer> max1 = str.stream().max((a, b) -> a - b);
//		System.out.println("Maximum::" + max1 + " " + "Minimum::" + min1);
	}

}
