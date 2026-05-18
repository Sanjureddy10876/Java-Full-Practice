package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringByLength {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("banana", "apple", "kiwi", "grane");

		// method 1
		List<String> result = str.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
		System.out.println(result);

		// method 2
//		str.stream().sorted(Comparator.comparingInt(w -> w.length()))
//		.forEach(c -> System.out.println(c));
	}

}
