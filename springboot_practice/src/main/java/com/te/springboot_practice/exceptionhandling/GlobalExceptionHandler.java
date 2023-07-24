package com.te.springboot_practice.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot_practice.customexception.EmployeeRegistrationUnSuccessfullException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeRegistrationUnSuccessfullException.class)
	public Map<String, String> employeeRegistrationUnSuccessfullException(
			EmployeeRegistrationUnSuccessfullException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", ex.getMessage());
		return map;

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String field = ((FieldError) error).getField();
			String defaultMessage = error.getDefaultMessage();
			map.put(field, defaultMessage);
		});
		return map;

	}

}
