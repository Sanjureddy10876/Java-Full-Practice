package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpringMgmt {
	
	
	@Autowired
	@Qualifier("acc2")
	Company company;
	
	@Autowired
	Employee employee;
	
	@Autowired
	Account account;
	
	public void companyData() {
		System.out.println("company Name : "+ company.getCompanyName()+" "+"Company ID : "+company.getCompanyId());
	}
	public void employeeData() {
		System.out.println("Employee Name : "+ employee.getName()+" "+"Employee ID : "+employee.getEmpId());
	}
	public void bankData() {
		System.out.println("Bank Name : "+ account.getName()+" "+"Bank Type : "+account.getType());
	}

}
