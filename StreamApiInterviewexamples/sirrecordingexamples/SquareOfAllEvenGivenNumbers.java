package com.stream.examples.sirrecordingexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//find the square of Even Numbers all given list from a list
public class SquareOfAllEvenGivenNumbers {
	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(4,6,8,2,9,3);
		List<Integer> result = str.stream().filter(n -> n % 2==0).map(n -> n*n).collect(Collectors.toList());
	System.out.println(result);
	}

}
