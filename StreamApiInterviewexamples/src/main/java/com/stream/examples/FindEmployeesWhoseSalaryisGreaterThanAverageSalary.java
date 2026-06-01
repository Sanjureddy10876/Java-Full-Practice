package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindEmployeesWhoseSalaryisGreaterThanAverageSalary {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Santhosh", 50000), new Employee(2, "Ravi", 70000),
				new Employee(3, "Kiran", 90000), new Employee(4, "David", 40000));
		Double avgsalary = employees.stream().mapToDouble(n -> n.getSalary()).average().getAsDouble();

		System.out.println(avgsalary);

		List<Employee> result = employees.stream().filter(n -> n.getSalary() > avgsalary).collect(Collectors.toList());
		System.out.println(result);
		result.forEach(emp -> System.out.println(emp.getName()));

	}

}
