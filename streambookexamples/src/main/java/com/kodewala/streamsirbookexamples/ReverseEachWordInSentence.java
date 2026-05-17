package com.kodewala.streamsirbookexamples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordInSentence {
	
	public static void main(String[] args) {
		String sentence = "kodewala is java traning academy";
			
	String result	=Arrays.stream(sentence.split(" "))
		.map(word-> new StringBuilder(word).reverse().toString())
		.collect(Collectors.joining(" "));
		System.out.println(result);
		
	
	}

}
