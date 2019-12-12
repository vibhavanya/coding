package com.mindtree.company.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.company.controller.CompanyController;
import com.mindtree.company.exception.NoEmployeeFound;

@RestControllerAdvice(assignableTypes = CompanyController.class)
public class HandlerController {
	@ExceptionHandler(NoEmployeeFound.class)
	public ResponseEntity<String> handle(NoEmployeeFound e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
