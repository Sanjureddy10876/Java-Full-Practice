package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLongestString {
	
	public static void main(String[] args) {
		List<String> str = Arrays.asList("cat","elephant","tiger","hippopotamus");
	
	
	String result=str.stream().max(Comparator.comparing(String::length)).orElse(" ");
		System.out.println(result);
	}

}
