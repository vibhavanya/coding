package com.mindtree.company.service;

import java.util.Set;

import com.mindtree.company.dto.DepartmentDto;
import com.mindtree.company.exception.ServiceException;

public interface DepartmentService {
	String addDepartmentWithEmployees(DepartmentDto departments);
	
	Set<DepartmentDto> getDepartmentWithEmployees() throws ServiceException;

}
