package com.te.springboot_practice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot_practice.customexception.EmployeeRegistrationUnSuccessfullException;
import com.te.springboot_practice.dto.EmployeeDto;
import com.te.springboot_practice.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/public")
public class EmployeeController {
	private final EmployeeService employeeService;

	@PostMapping(path = "/employeeRegistration")
	public ResponseEntity<String> employeeRegistration(@Valid @RequestBody EmployeeDto employeeDto) {
		Optional<EmployeeDto> employeeRegistration = employeeService.employeeRegistration(employeeDto);
		if (employeeRegistration.get() != null) {
			return ResponseEntity.ok().body("Employee Registration Successfull");
		}
		throw new EmployeeRegistrationUnSuccessfullException("Registration UnSuccessfull");

	}

}
