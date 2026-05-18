package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//How do you merge two unsorted arrays into single sorted array without duplicates
public class MergeUnsortedArrayWithoutDuplicates {
	public static void main(String[] args) {
		int[] arr = { 84, 53, 77, 90 };
		int[] arr1 = { 33, 13, 7, 27, 84 };

		Stream<Integer> res = Arrays.stream(arr).boxed();
		Stream<Integer> res1 = Arrays.stream(arr1).boxed();

	List<Integer> result	=Stream.concat(res, res1).sorted().distinct().collect(Collectors.toList());
	System.out.println(result);
	}

}
