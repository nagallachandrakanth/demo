package com.te.address.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.address.dto.AddressDto;
import com.te.address.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController {

	private final AddressService addressService;

	@PostMapping(path = "/addressRegistration")
	public void addressRegistration(@RequestBody AddressDto addressDto) {
		Optional<AddressDto> register = addressService.addressRegister(addressDto);
		if (register.get() != null) {
			return gener

		}

	}

}
