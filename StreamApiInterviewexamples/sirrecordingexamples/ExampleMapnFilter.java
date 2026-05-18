package com.stream.examples.sirrecordingexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleMapnFilter {
	// find the elements starts with 'B' and print it in Upper case
	public static void main(String[] args) {
		List<String> str = Arrays.asList("Bangalore", "Chennai", "Karnool", "Bombai", "Hyd", "Bengal");

		Stream<String> filteredStream = str.stream().filter(n -> n.startsWith("B"));
		Stream<String> mapedStream = filteredStream.map(c -> c.toUpperCase());
		List<String> result = mapedStream.collect(Collectors.toList());
		System.out.println(result);

	}

}
