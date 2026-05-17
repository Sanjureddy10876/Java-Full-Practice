package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeListAndRemoveDuplicates {
	public static void main(String[] args) {
	List<Integer> str = Arrays.asList(1,2,3);
	List<Integer> str1 = Arrays.asList(3,4,5);
	
	List<Integer> result = Stream.concat(str.stream(), str1.stream()).distinct().collect(Collectors.toList());
	
	System.out.println(result);
		
	}

}
