package com.stream.examples;

import java.util.List;
import java.util.Set;

public class UnsupportedException {

	public static void main(String[] args) {

		
		
		List<Integer> list=List.of(1,2,3,4,5,6);
		
		list.set(1, 5);
		
		
		Set<Integer> set=Set.of(1,2,4,4,5,6,7);
		
		
		System.out.println(set);
		
		//System.out.println(list);
	}
	

}
