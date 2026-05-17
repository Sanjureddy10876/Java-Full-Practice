package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecoundHighestNumber {
	
	public static void main(String[] args) {
		List<Integer> str = Arrays.asList(727,728,729,894,272,444);
		
		System.out.println(str.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
	}

}
