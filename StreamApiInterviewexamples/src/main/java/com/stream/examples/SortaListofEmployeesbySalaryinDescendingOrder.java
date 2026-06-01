package com.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Sort a list of employees by salary in descending order using Java Streams.
public class SortaListofEmployeesbySalaryinDescendingOrder {
	public static void main(String[] args) {
		List<Employee> str = Arrays.asList( new Employee(1, "Santhosh", 5000),
				new Employee(2, "Ravi", 70000),
			    new Employee(3, "Kiran", 90000),
			    new Employee(4, "David", 40000)
			); 
		
		str.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
		
	}

}
