package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateElements {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("Bangalore","Hyderabad","Kolkata","Mumbai","Bangalore","Kolkata");

		List<String> result	=str.stream().filter(n -> Collections.frequency(str, n) >1).collect(Collectors.toList());
	System.out.println(result);
	

	}

}
