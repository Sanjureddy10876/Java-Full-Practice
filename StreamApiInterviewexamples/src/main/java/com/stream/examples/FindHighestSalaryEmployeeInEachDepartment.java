package com.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindHighestSalaryEmployeeInEachDepartment {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Santhosh", "IT", 70000),
				new Employee(2, "Ravi", "HR", 50000), new Employee(3, "Kiran", "IT", 90000),
				new Employee(4, "David", "HR", 65000));

		Map<String, Optional<Employee>> result = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println(result);
		Map<String, Optional<Employee>> result2 = employees.stream().collect(Collectors
				.groupingBy(n -> n.getDepartment(), Collectors.maxBy(Comparator.comparing(n -> n.getSalary()))));
		System.out.println(result2);
	}

}
