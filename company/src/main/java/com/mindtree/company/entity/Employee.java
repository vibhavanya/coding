package com.mindtree.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "EMPLOYEE_EXPERIENCE")
	private int employeeExperience;

	@Column(name = "EMPLOYEEE_SALARY")
	// @Formula(value="employeeExperience*200000")
	private long employeeSalary;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department departments;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int employeeExperience, long employeeSalary,
			Department departments) {
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

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeExperience="
				+ employeeExperience + ", employeeSalary=" + employeeSalary + ", departments=" + departments + "]";
	}

}
