package com.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//How do you sort the given list of decimals in reverse order?
public class ReverseOrderExample {
	public static void main(String[] args) {
		
		List<Double> str = Arrays.asList(1.2,3.14,5.678,10.01);
		
		str.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));
		
	}

}
