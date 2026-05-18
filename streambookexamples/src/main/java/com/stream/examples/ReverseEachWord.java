package com.stream.examples;

import java.util.Arrays;
import java.util.stream.Collectors;

//Reverse each word of a string using Java 8 streams?
public class ReverseEachWord {
	public static void main(String[] args) {
		String str = "iam gangstar in hostel";

		String result = Arrays.stream(str.split(" ")).map(n -> new StringBuilder(n).reverse())
				.collect(Collectors.joining(","));
		System.out.println(result);
	}

}
