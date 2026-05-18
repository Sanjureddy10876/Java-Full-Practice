package com.stream.examples.sirrecordingexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Write a program to find even numbers from a given list of int.
public class FindEvenNumbersFromGivenEvenNumbers {
	public static void main(String[] args) {
		List<List<Integer>> str = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

		Stream<Integer> mapobj = str.stream().flatMap(n -> n.stream());
		List<Integer> result = mapobj.filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(result);
	}

}
