package com.stream.examples.sirrecordingexamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {
		List<String> str= new ArrayList<String>();
		str.add("Blr");
		str.add("Blr");
		str.add("Chennai");
		str.add("Hyd");
		str.add("Bihar");
		str.add("Bengal");
		str.add("Bengal");
		
	Stream<String> strobj	= str.stream();
	
	Stream<String> obj	=strobj.map(n -> n.toUpperCase());
	List<String> result	=obj.collect(Collectors.toList());
	
	System.out.println(result);
		
	}
}
