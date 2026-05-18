package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.List;

public class FindSumSquaresOfEvenNumbers {
	public static void main(String[] args) {
		List<Integer> str= Arrays.asList(1,2,3,4,5);
		
		int result =str.stream().filter(n->n%2 ==0).mapToInt(n -> n*n).sum();
		System.out.println(result);
	}

}
