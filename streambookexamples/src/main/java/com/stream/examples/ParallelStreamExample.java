package com.stream.examples;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("Bangalore","Academy","Kodewala");
		
//		List<String> result = str.parallelStream().filter(n->n.length()>5)
//				.map(item-> item.toUpperCase())
//				.collect(Collectors.toList());
//		System.out.println(ForkJoinPool.commonPool().getParallelism());
//		result.forEach(r -> System.out.println(r));
		
		
		List<String> str1 = Arrays.asList("10","20","30","100");
	str1.stream().mapToInt(s -> Integer.parseInt(s))
			.forEach(n-> System.out.println(n));
		
	}

}
