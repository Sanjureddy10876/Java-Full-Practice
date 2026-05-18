package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Input: List.of("Apple", "Banana", "avocado", "Cherry", "Mango")
//
//Expected Output: "BANANA, CHERRY, MANGO"
public class FilterTheListofDatStartsWith {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("Apple", "Banana", "avocado", "Cherry", "Mango");
		String result = str.stream().filter(n -> n.charAt(0) > 'A' && n.charAt(0) < 'a').map(n -> n.toUpperCase())
				.collect(Collectors.joining(","));
		System.out.println(result);
	}

}
