package com.carleaseapi.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carleaseapi.ws.exceptions.CarLeaseApiException;
import com.carleaseapi.ws.io.entity.CustomerEntity;
import com.carleaseapi.ws.io.repository.CustomerRepository;
import com.carleaseapi.ws.service.CustomerService;
import com.carleaseapi.ws.shared.Utils;
import com.carleaseapi.ws.shared.dto.CustomerDto;
import com.carleaseapi.ws.ui.model.response.ErrorMessages;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	Utils utils;

	/**
	 * Service Implementation for Creating Customer record in database
	 */
	@Override
	public CustomerDto createCustomer(CustomerDto cust) {
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(cust, customerEntity);

		customerEntity.setCustId(utils.generateCustId(15));

		CustomerEntity storedCustEntity = customerRepository.save(customerEntity);

		CustomerDto returnValue = new CustomerDto();
		BeanUtils.copyProperties(storedCustEntity, returnValue);

		return returnValue;
	}

	@Override
	public CustomerDto getCustomerById(String custId) {
		CustomerDto returnValue = new CustomerDto();
		CustomerEntity custEntity = customerRepository.findByCustId(custId);

		if (custEntity == null)
			throw new CarLeaseApiException("Customer with ID: " + custId + " not found");

		BeanUtils.copyProperties(custEntity, returnValue);

		return returnValue;
	}

	@Override
	public CustomerDto getCustomerByEmail(String email) {
		CustomerDto returnValue = new CustomerDto();
		CustomerEntity custEntity = customerRepository.findByEmail(email);

		if (custEntity == null)
			throw new CarLeaseApiException("Customer with email: " + email + " not found");

		BeanUtils.copyProperties(custEntity, returnValue);

		return returnValue;
	}

	@Override
	public List<CustomerDto> getCustomers() {
		List<CustomerDto> returnValue = new ArrayList<>();
		List<CustomerEntity> customers = (List<CustomerEntity>) customerRepository.findAll();

		for (CustomerEntity custEntity : customers) {
			CustomerDto custDto = new CustomerDto();
			BeanUtils.copyProperties(custEntity, custDto);
			returnValue.add(custDto);
		}
		return returnValue;
	}

	@Override
	public CustomerDto updateCustomer(String custId, CustomerDto cust) {
		CustomerDto returnValue = new CustomerDto();

		CustomerEntity customerEntity = customerRepository.findByCustId(custId);

		if (customerEntity == null) {
			throw new CarLeaseApiException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}

		customerEntity.setStreet(cust.getStreet());
		customerEntity.setHouseNumber(cust.getHouseNumber());
		customerEntity.setZipCode(cust.getZipCode());
		customerEntity.setPlace(cust.getPlace());

		CustomerEntity updatedCustDetails = customerRepository.save(customerEntity);
		BeanUtils.copyProperties(updatedCustDetails, returnValue);

		return returnValue;
	}

	@Override
	public void deleteCustomer(String custId) {
		CustomerEntity custEntity = customerRepository.findByCustId(custId);
		customerRepository.delete(custEntity);

	}

}
