package com.mindtree.company.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DepartmentDto {
	private int departmentId;
	private String departmentName;
	@JsonIgnoreProperties("departments")
	Set<EmployeeDto> employees;

	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String departmentName, Set<EmployeeDto> employees) {
		super();
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public DepartmentDto(int departmentId, String departmentName, Set<EmployeeDto> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeDto> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}

}
