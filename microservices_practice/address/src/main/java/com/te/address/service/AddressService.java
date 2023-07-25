package com.te.address.service;

import java.util.Optional;

import com.te.address.dto.AddressDto;

public interface AddressService {

	Optional<AddressDto> addressRegister(AddressDto addressDto);

}
