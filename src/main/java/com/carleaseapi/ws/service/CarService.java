package com.carleaseapi.ws.service;

import java.util.List;

import com.carleaseapi.ws.shared.dto.CarDto;
import com.carleaseapi.ws.ui.model.request.LeaseRateRequestModel;

/**
 * CarService Interface for Different services provided by Car Lease API
 * 
 * @author Deepesh
 *
 */
public interface CarService {
	/**
	 * Service for Creating Car record in database
	 * 
	 * @param car - Car DTO
	 * @return Car DTO
	 */
	CarDto createCar(CarDto car);

	/**
	 * Service for fetching Car record by CarId
	 * 
	 * @param carId
	 * @return Car DTO
	 */
	CarDto getCarByCarId(String carId);

	/**
	 * Service for Updating Car record in database
	 * 
	 * @param carId - Car ID
	 * @param car   - Car DTO
	 * @return Car DTO
	 */
	CarDto updateCar(String carId, CarDto car);

	/**
	 * Service for Deleting Car record in database
	 * 
	 * @param carId Car ID
	 */
	void deleteCar(String carId);

	/**
	 * Service Implementation for calculate Lease Rate calculate Lease Rate based on
	 * car details and other parameters
	 * 
	 * @param carId Card ID
	 * @param lease Object for parameters required to calculate Car Lease
	 * @return Car Lease Rate per month.
	 */
	Double calculateLeaseRate(String carId, LeaseRateRequestModel lease);

	/**
	 * Service for fetching list of car records
	 * 
	 * @return
	 */
	List<CarDto> getCars();
}
