package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CompanyMgmt {

	@Autowired
	@Qualifier("acc2")
	Company company;
	
	@Autowired
	Vehicle vehicle;
	
	public void printDetails() {
		System.out.println("Company Name"+ company.getName()+" "+"Company Details"+company.getDetails());
	}
	public void vehicleDetails() {
		System.out.println("vehicle Name "+ vehicle.getVehicleName()+"Vehicle Engine Name"+vehicle.getVehicleEngine());
	}
}
