package com.carleaseapi.ws.service;

import java.util.List;
import com.carleaseapi.ws.shared.dto.CustomerDto;

/**
 * CustomerService Interface for Different services provided by Customer API
 * 
 * @author Deepesh
 *
 */
public interface CustomerService {

	/**
	 * Service for Creating Customer record in database
	 * 
	 * @param cust - Customer DTO
	 * @return Customer DTO
	 */
	CustomerDto createCustomer(CustomerDto cust);

	/**
	 * Service for fetching Customer record by CustId
	 * 
	 * @param CustId
	 * @return Customer DTO
	 */
	CustomerDto getCustomerById(String custId);

	/**
	 * Service for fetching Customer record by email
	 * 
	 * @param emailid
	 * @return Customer DTO
	 */
	CustomerDto getCustomerByEmail(String email);

	/**
	 * Service for fetching list of customers records
	 * 
	 * @return
	 */
	List<CustomerDto> getCustomers();

	/**
	 * Service for Updating Customer record in database
	 * 
	 * @param custId - customer ID
	 * @param cust   - customer DTO
	 * @return Customer DTO
	 */
	CustomerDto updateCustomer(String custId, CustomerDto cust);

	/**
	 * Service for Deleting Customer record in database
	 * 
	 * @param CustID customer-id
	 */
	void deleteCustomer(String custId);

}
