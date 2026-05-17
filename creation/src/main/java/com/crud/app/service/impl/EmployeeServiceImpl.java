package com.crud.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.app.entity.EmployeeEntity;
import com.crud.app.repository.EmployeerRepository;
import com.crud.app.request.EmployeeRequest;
import com.crud.app.response.EmployeeResponse;
import com.crud.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeerRepository employeerRepository;

	@Override
	public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setAge(employeeRequest.getAge());
		employeeEntity.setName(employeeRequest.getName());
		employeeEntity.setDescription(employeeRequest.getDescription());
		employeeEntity.setJobRole(employeeRequest.getJobRole());
		employeeEntity.setSkinclr(employeeRequest.getSkinclr());

		EmployeeEntity response = employeerRepository.save(employeeEntity);

		if (response == null) {

			EmployeeResponse employeeResponse = new EmployeeResponse();
			employeeResponse.setStatus("Fail");
			employeeResponse.setReponse("Employee Not Created");
			return ResponseEntity.ok(employeeResponse);

		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setStatus("Sucess");
		employeeResponse.setReponse("Employee Record Created");

		return ResponseEntity.ok(employeeResponse);
	}

	@Override
	public ResponseEntity<EmployeeEntity> getEmployeeemployeesById(Long id) {
		Optional<EmployeeEntity> employee = employeerRepository.findById(id);

		if (employee.isPresent()) {
			return ResponseEntity.ok(employee.get());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(Long id, EmployeeRequest employeeRequest) {
		Optional<EmployeeEntity> employee = employeerRepository.findById(id);

		if (employee.isPresent()) {

			EmployeeEntity emp = employee.get();
			emp.setName(employeeRequest.getName());
			emp.setDescription(employeeRequest.getDescription());
			emp.setAge(employeeRequest.getAge());
			emp.setJobRole(employeeRequest.getJobRole());
			emp.setSkinclr(employeeRequest.getSkinclr());
			EmployeeEntity updatedemp = employeerRepository.save(emp);

			return ResponseEntity.ok(updatedemp);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<EmployeeEntity> patchupdateDetails(Long id, EmployeeRequest employeeRequest) {
		Optional<EmployeeEntity> employee = employeerRepository.findById(id);

		if (employee.isPresent()) {
			EmployeeEntity updatedEmployee = employee.get();
			if (employeeRequest.getName() != null) {
				updatedEmployee.setName(employeeRequest.getName());
			}
			if (employeeRequest.getDescription() != null) {
				updatedEmployee.setName(employeeRequest.getDescription());
			}
			if (employeeRequest.getAge() > 0) {
				updatedEmployee.setAge(employeeRequest.getAge());
			}
			if (employeeRequest.getJobRole() != null) {
				updatedEmployee.setJobRole(employeeRequest.getJobRole());
			}
			if (employeeRequest.getSkinclr() != null) {
				updatedEmployee.setJobRole(employeeRequest.getSkinclr());
			}
			EmployeeEntity response = employeerRepository.save(updatedEmployee);
			return ResponseEntity.ok(response);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public void pageSorting(int page, int records) {
	Pageable pageable = PageRequest.of(page, records);
	org.springframework.data.domain.Page<EmployeeEntity> pages =employeerRepository.findAll(pageable);
		for(EmployeeEntity employees : pages.getContent()) {
			System.out.println(employees.getName()+" "+employees.getAge()+" "+employees.getJobRole());
		}
	}

}
