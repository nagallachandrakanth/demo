package com.te.springboot_practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@GenericGenerator(name = "emp_seq", strategy = "com.te.springboot_practice.entity.StringPrefixSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TYC_"),
			@Parameter(name = StringPrefixSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private String name;
	private String emailID;
	private String phoneNumber;
	private String bloodGroup;
	private Double salary;

}
