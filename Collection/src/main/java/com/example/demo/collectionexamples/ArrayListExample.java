package com.example.demo.collectionexamples;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		List<Integer> arr = new CopyOnWriteArrayList<Integer>();
		arr.add(23);
		arr.add(26);
		arr.add(27);
		arr.add(28);
		System.out.println("Total products"+arr.size());
		
	Iterator<Integer> itr	=arr.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	}

}
