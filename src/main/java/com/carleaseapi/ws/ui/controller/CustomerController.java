package com.carleaseapi.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carleaseapi.ws.service.CustomerService;
import com.carleaseapi.ws.shared.dto.CustomerDto;
import com.carleaseapi.ws.ui.model.request.CustomerDetailsRequestModel;
import com.carleaseapi.ws.ui.model.request.OperationStatusModel;
import com.carleaseapi.ws.ui.model.response.CustomerRest;

/**
 * Rest Controller class for accepting all requests for Creating, Updating,
 * Listing and Deleting Customer details
 * 
 * Request URL : http://localhost:8080/customers
 * 
 * @author Deepesh
 *
 */

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * Get Mapper for fetching customer by emailid
	 * 
	 * @param email - customer emailid
	 * @return Customer Record
	 */
	@GetMapping(path = "/{email}")
	public CustomerRest getCustomer(@PathVariable String email) {
		CustomerRest returnValue = new CustomerRest();
		CustomerDto custDto = customerService.getCustomerByEmail(email);
		BeanUtils.copyProperties(custDto, returnValue);
		return returnValue;
	}

	/**
	 * Get List of Customer details
	 * 
	 * @return Customer Object List
	 */
	@GetMapping
	public List<CustomerRest> getCustomers() {
		List<CustomerRest> returnValue = new ArrayList<>();
		List<CustomerDto> customers = customerService.getCustomers();

		for (CustomerDto custDto : customers) {
			CustomerRest custRest = new CustomerRest();
			BeanUtils.copyProperties(custDto, custRest);
			returnValue.add(custRest);
		}
		return returnValue;
	}

	/**
	 * Post Mapper to create records for Customer
	 * 
	 * @param customerDetails - Customer details like Name, Address and phonenumber
	 * @return Generated Customer-Id
	 */
	@PostMapping
	public CustomerRest createCustomer(@RequestBody CustomerDetailsRequestModel customerDetails) {
		CustomerRest returnValue = new CustomerRest();

		CustomerDto custDto = new CustomerDto();
		BeanUtils.copyProperties(customerDetails, custDto);

		CustomerDto createdCustomer = customerService.createCustomer(custDto);
		BeanUtils.copyProperties(createdCustomer, returnValue);

		return returnValue;
	}

	/**
	 * Put Mapper to update records for Customer
	 * 
	 * @param id              - customer id
	 * @param customerDetails - customer fields to be updated
	 * @return customer data.
	 */
	@PutMapping(path = "/{id}")
	public CustomerRest updateCustomer(@PathVariable String id,
			@RequestBody CustomerDetailsRequestModel customerDetails) {
		CustomerRest returnValue = new CustomerRest();

		CustomerDto custDto = new CustomerDto();
		BeanUtils.copyProperties(customerDetails, custDto);

		CustomerDto updatedCustomer = customerService.updateCustomer(id, custDto);

		BeanUtils.copyProperties(updatedCustomer, returnValue);

		return returnValue;
	}

	/**
	 * Delete customer record based on customer generated id
	 * 
	 * @param id - Customer Id
	 * @return Status
	 */
	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteCustomer(@PathVariable String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName("DELETE");

		customerService.deleteCustomer(id);

		returnValue.setOperationResult("SUCCESS");
		return returnValue;
	}

}
