package com.stream.examples.sirrecordingexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
// find the cities those are greater then 5
	public static void main(String[] args) {
		
		List<List<String>> str = Arrays.asList(Arrays.asList("Bangalore","Chennai")
				,Arrays.asList("Kerela","Mangolre","kol"), Arrays.asList("Hyderabad","Bengal"));
	Stream<String> flatteredStreamList	= str.stream().flatMap(c -> c.stream());
	List<String> resut	=flatteredStreamList.filter(n -> n.length() > 5).collect(Collectors.toList());
		System.out.println(resut);
	}
}
