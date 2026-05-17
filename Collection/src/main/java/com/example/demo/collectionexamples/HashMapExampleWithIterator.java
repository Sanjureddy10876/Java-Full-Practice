package com.example.demo.collectionexamples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExampleWithIterator {
	public static void main(String[] args) {
		
		Map<Integer, String> str = new HashMap<>();
		str.put(21, "Santhosh");
		str.put(22, "Reddy");
		str.put(23, "Tree");
		str.put(24, "lenovo");
		str.put(25, "Dell");
		
	    Set<Entry<Integer, String>> setstr	= str.entrySet();
	    
	   Iterator<Entry<Integer, String>> res =setstr.iterator();
	   
	  while(res.hasNext()) {
		 Entry<Integer, String> result = res.next();
		 System.out.print(result.getValue());
		 System.out.println(result.getKey());
	  }
	  

	}

}
