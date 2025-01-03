package com.carleaseapi.ws.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carleaseapi.ws.io.entity.CarEntity;

/**
 * Car Repository for performing CRUD operations Currently one method is
 * implemented but can be extended for other search criteria.
 * 
 * @author Deepesh
 *
 */
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

	/**
	 * @param carId
	 * @return
	 */
	CarEntity findByCarId(String carId);

}
