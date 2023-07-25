package com.te.address.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.address.dto.AddressDto;
import com.te.address.entity.Address;
import com.te.address.repository.AddressRepository;
import com.te.address.service.AddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	@Override
	public Optional<AddressDto> addressRegister(AddressDto addressDto) {
		if (addressDto != null) {
			Address address = new Address();
			BeanUtils.copyProperties(addressDto, address);
			addressRepository.save(address);
			return Optional.ofNullable(addressDto);
		}
		return null;

	}

}
