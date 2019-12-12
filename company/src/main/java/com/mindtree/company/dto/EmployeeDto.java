package com.mindtree.company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class EmployeeDto {
	private int employeeId;
	private String employeeName;
	private int employeeExperience;

	public EmployeeDto(String employeeName, int employeeExperience, DepartmentDto departments) {
		super();
		this.employeeName = employeeName;
		this.employeeExperience = employeeExperience;
		this.departments = departments;
	}

	private long employeeSalary;
	@JsonIgnoreProperties("employees")
	private DepartmentDto departments;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(int employeeId, String employeeName, int employeeExperience, long employeeSalary,
			DepartmentDto departments) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeExperience = employeeExperience;
		this.employeeSalary = employeeSalary;
		this.departments = departments;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeExperience() {
		return employeeExperience;
	}

	public void setEmployeeExperience(int employeeExperience) {
		this.employeeExperience = employeeExperience;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public DepartmentDto getDepartments() {
		return departments;
	}

	public void setDepartments(DepartmentDto departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeExperience="
				+ employeeExperience + ", employeeSalary=" + employeeSalary + ", departments=" + departments + "]";
	}

}
