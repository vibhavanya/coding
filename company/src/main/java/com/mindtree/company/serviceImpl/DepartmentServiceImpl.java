package com.mindtree.company.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.dto.DepartmentDto;
import com.mindtree.company.dto.EmployeeDto;
import com.mindtree.company.entity.Department;
import com.mindtree.company.entity.Employee;
import com.mindtree.company.exception.NoEmployeeFound;
import com.mindtree.company.exception.ServiceException;
import com.mindtree.company.repository.DepartmentRepository;
import com.mindtree.company.repository.EmployeeRepository;
import com.mindtree.company.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public String addDepartmentWithEmployees(DepartmentDto departments) {
		ModelMapper mapper = new ModelMapper();
		Department temp = mapper.map(departments, Department.class);
		Set<EmployeeDto> employeeSet = departments.getEmployees();
		Set<Employee> employeeresult = new HashSet<Employee>();
		for (EmployeeDto employee : employeeSet) {
			Employee temp2 = mapper.map(employee, Employee.class);
			temp2.setEmployeeSalary(temp2.getEmployeeExperience() * 200000);
			temp2.setDepartments(temp);
			employeeresult.add(temp2);
		}
		temp.setEmployees(employeeresult);
		departmentRepository.save(temp);
		return "Data Inserted";
	}

	@Override
	public Set<DepartmentDto> getDepartmentWithEmployees() throws ServiceException {
		ModelMapper mapper = new ModelMapper();
		Set<DepartmentDto> departmentDtos = new HashSet<>();
		List<Department> departments = departmentRepository.findAll();
		for (Department department : departments) {
			float totalsalary = 0;
			for (Employee employee : department.getEmployees()) {
				totalsalary += employee.getEmployeeSalary();
			}
			try
			{if (totalsalary >= 1000000) {
				DepartmentDto departmentDto = mapper.map(departments, DepartmentDto.class);
				departmentDtos.add(departmentDto);

			}
			else {
				throw new NoEmployeeFound("No such employee under that amount");
			}
			}
			catch (NoEmployeeFound e) {
				throw new ServiceException(e);
			}
			
		}
		return departmentDtos;
	}
}
