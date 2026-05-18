package com.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterEmployeeObject {
	public static void main(String[] args) {
		List<Employee> str = Arrays.asList(new Employee("Santhu", "IT", 50000), new Employee("Ravi", "HR", 40000),
				new Employee("Kiran", "IT", 70000), new Employee("Mahesh", "Finance", 60000),
				new Employee("Ajay", "IT", 55000));

// Task:
//
//Using Streams:
//
//Filter only IT employees
//Sort them by salary descending
//Get only employee names
//Collect into a List
		List<String> result = str.stream().filter(n -> n.getDepartment().equals("IT"))
				.sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).map(n -> n.getName())
				.collect(Collectors.toList());
		System.out.println(result);
		

		// Find the 2nd highest salary employee name using Streams only.
		Employee res = str.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).skip(1).findFirst()
				.get();
		System.out.println(res.toString());
		

		// Find the highest paid employee in each department using Streams.
		Map<String, Optional<Employee>> results = str.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

		System.out.println(results);
	}

}
