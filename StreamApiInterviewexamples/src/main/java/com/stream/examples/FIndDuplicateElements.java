package com.stream.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FIndDuplicateElements {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 1, 7, 3);

		List<Integer> res = nums.stream().filter(n -> Collections.frequency(nums, n) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println(res);

		Set<Integer> str = new HashSet<>();

		List<Integer> method2res = nums.stream().filter(n -> !str.add(n)).distinct().collect(Collectors.toList());
		System.out.println(method2res);
	}

}
