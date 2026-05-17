package com.crud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.app.entity.EmployeeEntity;
import com.crud.app.request.EmployeeRequest;
import com.crud.app.request.PageEmployeeRequest;
import com.crud.app.response.EmployeeResponse;
import com.crud.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createEmp")
	public ResponseEntity<EmployeeResponse> creatEmployee(@RequestBody EmployeeRequest employeeRequest){
		return employeeService.createEmployee(employeeRequest);
	}
	
	
	@GetMapping("/getemployeeById/{id}")
	public ResponseEntity<EmployeeEntity> getemployee(@PathVariable Long id){
		return employeeService.getEmployeeemployeesById(id);
	}
	
	
	@PutMapping("/updateempDetails/{id}")
	public ResponseEntity<EmployeeEntity> updsteEmployeeDetails(@PathVariable Long id,@RequestBody EmployeeRequest employeeRequest){	
		return employeeService.updateEmployeeDetails(id, employeeRequest);
	}
	
	@PatchMapping("patchdetails/{id}")
	public ResponseEntity<EmployeeEntity> patchEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest){	
		return employeeService.patchupdateDetails(id, employeeRequest);
	}
	@GetMapping("find")
	public String getPageEmp(@RequestBody PageEmployeeRequest pageEmployeeRequest) {
	int page	=pageEmployeeRequest.getPage();
	int records	=pageEmployeeRequest.getRecords();
		employeeService.pageSorting(page, records);
		return "Location is saved";
	}

	
}
