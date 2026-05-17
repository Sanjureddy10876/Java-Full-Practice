package com.crud.app.service;

import org.springframework.http.ResponseEntity;

import com.crud.app.entity.EmployeeEntity;
import com.crud.app.request.EmployeeRequest;
import com.crud.app.response.EmployeeResponse;

public interface EmployeeService {
	
	public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest);
	
	public ResponseEntity<EmployeeEntity> getEmployeeemployeesById(Long id);
	
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(Long id, EmployeeRequest employeeRequest);

	public ResponseEntity<EmployeeEntity> patchupdateDetails(Long id, EmployeeRequest employeeRequest);
	public void pageSorting(int page, int records);
}
