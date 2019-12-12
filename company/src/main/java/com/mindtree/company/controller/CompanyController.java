package com.mindtree.company.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.company.dto.DepartmentDto;
import com.mindtree.company.exception.ServiceException;
import com.mindtree.company.service.DepartmentService;
import com.mindtree.company.service.EmployeeService;

@RestController
public class CompanyController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save")
	private ResponseEntity<String> resEntity(@RequestBody DepartmentDto departmentDto) {
		String iString = departmentService.addDepartmentWithEmployees(departmentDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("SET", "Saved");
		return new ResponseEntity<String>(iString, headers, HttpStatus.OK);
	}

	@GetMapping("/get")
	private Set<DepartmentDto> getDepartmentWithEmployee() throws ServiceException {
		return departmentService.getDepartmentWithEmployees();
	}

}
