package com.te.springboot_practice.service;

import java.util.Optional;

import com.te.springboot_practice.dto.EmployeeDto;

public interface EmployeeService {

	Optional<EmployeeDto> employeeRegistration(EmployeeDto employeeDto);

}
