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

import com.carleaseapi.ws.service.CarService;
import com.carleaseapi.ws.shared.dto.CarDto;
import com.carleaseapi.ws.ui.model.request.CarDetailsRequestModel;
import com.carleaseapi.ws.ui.model.request.LeaseRateRequestModel;
import com.carleaseapi.ws.ui.model.request.OperationStatusModel;
import com.carleaseapi.ws.ui.model.response.CarRest;

/**
 * Rest Controller class for accepting all requests for Creating, Updating,
 * Listing and Deleting Car details
 * 
 * Request URL : http://localhost:8080/cars
 * 
 * @author Deepesh
 *
 */

@RestController
@RequestMapping("cars")
public class CarController {

	@Autowired
	CarService carService;

	/**
	 * Get Car details based on Car ID
	 * 
	 * @param id Car-id
	 * @return Car details CarObject
	 */
	@GetMapping(path = "/{id}")
	public CarRest getCar(@PathVariable String id) {
		CarRest returnValue = new CarRest();
		CarDto carDto = carService.getCarByCarId(id);
		BeanUtils.copyProperties(carDto, returnValue);
		return returnValue;
	}

	/**
	 * Get List of Car details
	 * 
	 * @return CarDetails Object List
	 */
	@GetMapping
	public List<CarRest> getCars() {
		List<CarRest> returnValue = new ArrayList<>();
		List<CarDto> cars = carService.getCars();

		for (CarDto carDto : cars) {
			CarRest carRest = new CarRest();
			BeanUtils.copyProperties(carDto, carRest);
			returnValue.add(carRest);
		}
		return returnValue;
	}

	/**
	 * Service to Create Car record
	 * 
	 * @param carDetails - like make, model, version, gross and net price and
	 *                   Mileage
	 * @return CarObject with Card generated id
	 */
	@PostMapping
	public CarRest createCar(@RequestBody CarDetailsRequestModel carDetails) {
		CarRest returnValue = new CarRest();

		CarDto carDto = new CarDto();
		BeanUtils.copyProperties(carDetails, carDto);

		CarDto createdCar = carService.createCar(carDto);

		BeanUtils.copyProperties(createdCar, returnValue);

		return returnValue;
	}

	/**
	 * 
	 * @param id
	 * @param carDetails carDetails - like net price, Co2 emission and Mileage
	 * @return CarObject
	 */
	@PutMapping(path = "/{id}")
	public CarRest updateCar(@PathVariable String id, @RequestBody CarDetailsRequestModel carDetails) {
		CarRest returnValue = new CarRest();

		CarDto carDto = new CarDto();
		BeanUtils.copyProperties(carDetails, carDto);

		CarDto createdCar = carService.updateCar(id, carDto);

		BeanUtils.copyProperties(createdCar, returnValue);

		return returnValue;
	}

	/**
	 * Delete car record based on Car generated id
	 * 
	 * @param id - CarId
	 * @return Status
	 */
	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteCar(@PathVariable String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName("DELETE");

		carService.deleteCar(id);

		returnValue.setOperationResult("SUCCESS");
		return returnValue;
	}

	/**
	 * Service to calculate Lease Rate based on car details and other parameters
	 * like lease rate and duration
	 * 
	 * @param id           - CarId
	 * @param leaseDetails - object contains Interest Rate and Duration
	 * @return Lease Rate per month.
	 */
	@PostMapping(path = "/{id}/calculate-leaserate")
	public String calculateLeaseRate(@PathVariable String id, @RequestBody LeaseRateRequestModel leaseDetails) {

		return "Calculated Lease Rate for CarId : " + id + " : " + carService.calculateLeaseRate(id, leaseDetails);
	}
}
