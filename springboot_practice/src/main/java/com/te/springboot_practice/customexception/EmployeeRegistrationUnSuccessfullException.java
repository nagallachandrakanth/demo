package com.te.springboot_practice.customexception;

public class EmployeeRegistrationUnSuccessfullException extends RuntimeException {

	public EmployeeRegistrationUnSuccessfullException(String message) {
		super(message);

	}

}
