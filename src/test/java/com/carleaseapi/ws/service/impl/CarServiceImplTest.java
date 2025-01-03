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
import com.carleaseapi.ws.io.repository.CarRepository;
import com.carleaseapi.ws.shared.Utils;
import com.carleaseapi.ws.shared.dto.CarDto;

/**
 * CarService Junit Tests
 * @author Deepesh
 *
 */
class CarServiceImplTest {

	@InjectMocks
	CarServiceImpl carService;

	@Mock
	CarRepository carRepository;

	@Mock
	Utils utils;

	CarEntity carEntity;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		carEntity = new CarEntity();
		carEntity.setId(1L);
		carEntity.setCarId("IvsNg2Mr6PaejmT");
		carEntity.setMake("BMW");
		carEntity.setModel("Sedan");
		carEntity.setVersion("X5");
		carEntity.setCo2Emission(99.00);
		carEntity.setGrossPrice(36000.00);
		carEntity.setNetPrice(20000.00);
		carEntity.setMilageKmsPerYear(45000.00);
	}

	@Test
	final void testGetCar() {
		when(carRepository.findByCarId(anyString())).thenReturn(carEntity);
		CarDto carDto = carService.getCarByCarId("IvsNg2Mr6PaejmT");
		assertNotNull(carDto);
		assertEquals("BMW", carDto.getMake());
	}

	@Test
	final void testCreateCar() {
		when(carRepository.findByCarId(anyString())).thenReturn(null);
		when(utils.generateCarId(anyInt())).thenReturn("hgfnghtyrir884");
		when(carRepository.save(any(CarEntity.class))).thenReturn(carEntity);

		CarDto carDto = new CarDto();

		carDto.setMake("BMW");
		carDto.setModel("Sedan");
		carDto.setVersion("X5");
		carDto.setCo2Emission(99.00);
		carDto.setGrossPrice(36000.00);
		carDto.setNetPrice(20000.00);
		carDto.setMilageKmsPerYear(45000.00);

		CarDto storedCarDetails = carService.createCar(carDto);
		assertNotNull(storedCarDetails);
		assertEquals(carEntity.getMake(), storedCarDetails.getMake());
		assertEquals(carEntity.getModel(), storedCarDetails.getModel());
		assertNotNull(storedCarDetails.getCarId());

		verify(carRepository, times(1)).save(any(CarEntity.class));
	}

}
