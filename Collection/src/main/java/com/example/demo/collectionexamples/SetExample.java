package com.example.demo.collectionexamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		
		Set<String> str = new HashSet<>();
		str.add("madivala");
		str.add("btm");
		str.add("silboard");
		str.add("btm");
		str.add("bottle");
		
//		for(String item : str) {
//			System.out.println(item);
//
//		}
		
	    Iterator<String> result	=str.iterator();
	    while(result.hasNext()) {
	    String val	= result.next();
	    if(val.equalsIgnoreCase("bottle")) {
	    	result.remove();
	    }
	   
	 
	    System.out.println(val);
	    System.out.println(str);
	    }
	    
		
	}
}
