package com.kodewala.stringbuilder.examples;

public class HomeWorkTask {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("SELECT 8 FROM employees WHERE 1=1");
		boolean filterByDepartment= true;
		
		if (filterByDepartment) {
			sb.append(" AND deparment ='IT' ");  
		}
		boolean filteredBySalary = true;
		if (filteredBySalary) {
			sb.append(" AND salary > 50000");
		}
		
		boolean filteredjoiningdate = true;
		if (filteredjoiningdate) {
			sb.append(" AND joining-date >= '2020-01-01'");	
		}
		
		System.out.println(sb.toString());
	}

}
