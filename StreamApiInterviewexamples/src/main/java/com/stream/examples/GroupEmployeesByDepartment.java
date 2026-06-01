package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByDepartment {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Santhosh", "IT"), new Employee(2, "Ravi", "HR"),
				new Employee(3, "Kiran", "IT"), new Employee(4, "David", "Admin"));

		Map<String, List<String>> result = employees.stream().collect(Collectors.groupingBy(n -> n.getDepartment(),
				Collectors.mapping(n -> n.getName(), Collectors.toList())));
		System.out.println(result);
		
		

	}

}
