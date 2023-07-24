package com.te.springboot_practice.service.impl;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.te.springboot_practice.dto.EmployeeDto;
import com.te.springboot_practice.entity.Employee;
import com.te.springboot_practice.repository.EmployeeRepository;
import com.te.springboot_practice.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final JavaMailSender javaMailSender;

	@Override
	public Optional<EmployeeDto> employeeRegistration(EmployeeDto employeeDto) {
		if (employeeDto != null) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDto, employee);
			employeeRepository.save(employee);
			try {
				mailSending(employeeDto.getEmailID(), "Employee Registration Successfull", "Dear Sir,\nPlease find the attached doucument\n Regards", "C:\\Users\\CHANDRAKANTH\\Downloads\\Core Java Interview Questions & Answers.Pdf.pdf");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return Optional.ofNullable(employeeDto);
		}
		return Optional.ofNullable(null);

	}

	public void mailSending(String to, String subject, String text, String attachment) throws MessagingException {
		MimeMessage createMimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(createMimeMessage, true);
		mimeMessageHelper.setFrom("n.chandrakanthchowdary@gmail.com");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(text);
		FileSystemResource fileSystemResource = new FileSystemResource(attachment);
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		javaMailSender.send(createMimeMessage);
	}

}
