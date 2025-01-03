package com.carleaseapi.ws.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carleaseapi.ws.io.entity.CustomerEntity;

/**
 * Customer Repository for performing CRUD operations Currently two method are
 * implemented but can be extended for other search criteria.
 * 
 * @author Deepesh
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

	/**
	 * Find Customer by Cust-id
	 * 
	 * @param custId - customer Id
	 * @return Customer Entity
	 */
	CustomerEntity findByCustId(String carId);

	/**
	 * Find Customer by Email
	 * 
	 * @param custId - email Id
	 * @return Customer Entity
	 */
	CustomerEntity findByEmail(String email);

}
