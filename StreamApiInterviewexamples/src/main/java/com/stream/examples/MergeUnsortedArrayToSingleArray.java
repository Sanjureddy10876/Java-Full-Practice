package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//How do you merge two unsorted arrays into single sorted array using Java 8 streams?
public class MergeUnsortedArrayToSingleArray {

	public static void main(String[] args) {
		int[] arr = { 84, 53, 77, 90 };
		int[] arr1 = { 33, 13, 7, 27 };

		Stream<Integer> stream1 = Arrays.stream(arr).boxed();
		Stream<Integer> stream2 = Arrays.stream(arr1).boxed();
		List<Integer> result = Stream.concat(stream1, stream2).sorted().collect(Collectors.toList());
		System.out.println(result);
	}
}
