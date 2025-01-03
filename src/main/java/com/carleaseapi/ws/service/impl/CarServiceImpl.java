package com.carleaseapi.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carleaseapi.ws.exceptions.CarLeaseApiException;
import com.carleaseapi.ws.io.entity.CarEntity;
import com.carleaseapi.ws.io.repository.CarRepository;
import com.carleaseapi.ws.service.CarService;
import com.carleaseapi.ws.shared.Utils;
import com.carleaseapi.ws.shared.dto.CarDto;
import com.carleaseapi.ws.ui.model.request.LeaseRateRequestModel;
import com.carleaseapi.ws.ui.model.response.ErrorMessages;

/**
 * CarService Implementation for Different services provided by Car Leasse API
 * 
 * @author Admin
 *
 */
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	Utils utils;

	/**
	 * Service Implementation for Creating Car record in database
	 */
	@Override
	public CarDto createCar(CarDto car) {
		CarEntity carEntity = new CarEntity();
		BeanUtils.copyProperties(car, carEntity);

		carEntity.setCarId(utils.generateCarId(15));

		CarEntity storedCarEntity = carRepository.save(carEntity);

		CarDto returnValue = new CarDto();
		BeanUtils.copyProperties(storedCarEntity, returnValue);

		return returnValue;
	}

	/**
	 * Service Implementation for fetching Car record by CarId
	 */
	@Override
	public CarDto getCarByCarId(String carId) {
		CarDto returnValue = new CarDto();
		CarEntity carEntity = carRepository.findByCarId(carId);

		if (carEntity == null)
			throw new CarLeaseApiException("Car with ID: " + carId + " not found");

		BeanUtils.copyProperties(carEntity, returnValue);

		return returnValue;
	}

	/**
	 * Service Implementation for Updating Car record in database
	 */
	@Override
	public CarDto updateCar(String carId, CarDto car) {
		CarDto returnValue = new CarDto();

		CarEntity carEntity = carRepository.findByCarId(carId);

		if (carEntity == null) {
			throw new CarLeaseApiException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}

		carEntity.setCo2Emission(car.getCo2Emission());
		carEntity.setNetPrice(car.getNetPrice());
		carEntity.setMilageKmsPerYear(car.getMilageKmsPerYear());

		CarEntity updatedCarDetails = carRepository.save(carEntity);
		BeanUtils.copyProperties(updatedCarDetails, returnValue);

		return returnValue;
	}

	/**
	 * Service Implementation for Deleting Car record in database
	 */
	@Override
	public void deleteCar(String carId) {
		CarEntity carEntity = carRepository.findByCarId(carId);
		carRepository.delete(carEntity);

	}

	/**
	 * Service Implementation for calculate Lease Rate calculate Lease Rate based on
	 * car details and other parameters
	 */
	@Override
	public Double calculateLeaseRate(String carId, LeaseRateRequestModel lease) {
		CarEntity carEntity = carRepository.findByCarId(carId);

		return (((carEntity.getMilageKmsPerYear() / 12) * lease.getDuration()) / carEntity.getNetPrice())
				+ (((lease.getInterestRate() / 100) * carEntity.getNetPrice()) / 12);
	}

	/**
	 * Service Implementation for fetching list of car records
	 */
	@Override
	public List<CarDto> getCars() {
		List<CarDto> returnValue = new ArrayList<>();
		List<CarEntity> cars = (List<CarEntity>) carRepository.findAll();

		for (CarEntity carEntity : cars) {
			CarDto carDto = new CarDto();
			BeanUtils.copyProperties(carEntity, carDto);
			returnValue.add(carDto);
		}
		return returnValue;
	}

}
