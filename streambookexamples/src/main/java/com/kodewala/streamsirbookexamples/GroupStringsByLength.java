package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByLength {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("one","three","five","four","six");
		
		Map<Integer, List<String>> result =str.stream()
		.collect(Collectors.groupingBy(n -> n.length()));
		System.out.println(result);
		
	}

}
