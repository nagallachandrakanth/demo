package com.te.springboot_practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDto {

	@NotBlank
	private String name;
	@Email
	private String emailID;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String bloodGroup;
	@Min(value = 0)
	private Double salary;

}
