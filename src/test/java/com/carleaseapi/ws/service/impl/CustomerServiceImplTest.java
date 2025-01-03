package com.carleaseapi.ws.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.carleaseapi.ws.io.entity.CarEntity;
import com.carleaseapi.ws.io.entity.CustomerEntity;
import com.carleaseapi.ws.io.repository.CarRepository;
import com.carleaseapi.ws.io.repository.CustomerRepository;
import com.carleaseapi.ws.shared.Utils;
import com.carleaseapi.ws.shared.dto.CarDto;
import com.carleaseapi.ws.shared.dto.CustomerDto;

class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerService;

	@Mock
	CustomerRepository customerRepository;

	@Mock
	Utils utils;

	CustomerEntity custEntity;


	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		custEntity = new CustomerEntity();
		custEntity.setId(1L);
		custEntity.setCustId("IvsNg2Mr6PaejmT");
		custEntity.setFirstName("Deepesh");
		custEntity.setLastName("Mishra");
		custEntity.setEmail("deepeshmishra@gmail.com");
		custEntity.setStreet("Parkzichtlaan");
		custEntity.setHouseNumber(242);
		custEntity.setZipCode("3544MN");
		custEntity.setPlace("Utrecht");
		custEntity.setPhoneNumber("0644460636");
	}

	@Test
	final void testGetCustomer() {
		when(customerRepository.findByCustId(anyString())).thenReturn(custEntity);
		CustomerDto custDto = customerService.getCustomerById("IvsNg2Mr6PaejmT");
		assertNotNull(custDto);
		assertEquals("Deepesh", custDto.getFirstName());
	}

	@Test
	final void testCreateCustomer() {
		when(customerRepository.findByCustId(anyString())).thenReturn(null);
		when(utils.generateCustId(anyInt())).thenReturn("hgfnghtyrir884");
		when(customerRepository.save(any(CustomerEntity.class))).thenReturn(custEntity);

		CustomerDto custDto = new CustomerDto();	
		custDto.setFirstName("Deepesh");
		custDto.setLastName("Mishra");
		custDto.setEmail("deepeshmishra@gmail.com");
		custDto.setStreet("Parkzichtlaan");
		custDto.setHouseNumber(242);
		custDto.setZipCode("3544MN");
		custDto.setPlace("Utrecht");
		custDto.setPhoneNumber("0644460636");

		CustomerDto storedCustDetails = customerService.createCustomer(custDto);
		assertNotNull(storedCustDetails);
		assertEquals(custEntity.getFirstName(), storedCustDetails.getFirstName());
		assertEquals(custEntity.getEmail(), storedCustDetails.getEmail());
		assertNotNull(storedCustDetails.getCustId());

		verify(customerRepository, times(1)).save(any(CustomerEntity.class));
	}

}
