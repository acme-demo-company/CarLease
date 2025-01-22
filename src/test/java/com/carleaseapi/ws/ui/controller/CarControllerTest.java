package com.carleaseapi.ws.ui.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.junit.jupiter.api.extension.ExtendWith;

import com.carleaseapi.ws.service.CarService;
import com.carleaseapi.ws.shared.dto.CarDto;
import com.carleaseapi.ws.ui.model.request.CarDetailsRequestModel;
import com.carleaseapi.ws.ui.model.request.LeaseRateRequestModel;
import com.carleaseapi.ws.ui.model.request.OperationStatusModel;
import com.carleaseapi.ws.ui.model.response.CarRest;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {

    @InjectMocks
    private CarController carController;

    @Mock
    private CarService carService;

    private CarDto carDto;
    private CarRest carRest;

    @BeforeEach
    public void setUp() {
        carDto = new CarDto();
        carDto.setCarId("CAR123");
        carDto.setMake("Toyota");
        carDto.setModel("Corolla");

        carRest = new CarRest();
        BeanUtils.copyProperties(carDto, carRest);
    }

    @Test
    public void testGetCar() {
        when(carService.getCarByCarId(anyString())).thenReturn(carDto);

        CarRest result = carController.getCar("CAR123");

        assertEquals(carRest.getCarId(), result.getCarId());
        assertEquals(carRest.getMake(), result.getMake());
        assertEquals(carRest.getModel(), result.getModel());
    }

    @Test
    public void testGetCars() {
        when(carService.getCars()).thenReturn(Arrays.asList(carDto));

        List<CarRest> result = carController.getCars();

        assertEquals(1, result.size());
        assertEquals(carRest.getCarId(), result.get(0).getCarId());
    }

    @Test
    public void testCreateCar() {
        when(carService.createCar(any(CarDto.class))).thenReturn(carDto);

        CarDetailsRequestModel carDetails = new CarDetailsRequestModel();
        BeanUtils.copyProperties(carDto, carDetails);

        CarRest result = carController.createCar(carDetails);

        assertEquals(carRest.getCarId(), result.getCarId());
    }

    @Test
    public void testUpdateCar() {
        when(carService.updateCar(anyString(), any(CarDto.class))).thenReturn(carDto);

        CarDetailsRequestModel carDetails = new CarDetailsRequestModel();
        BeanUtils.copyProperties(carDto, carDetails);

        CarRest result = carController.updateCar("CAR123", carDetails);

        assertEquals(carRest.getCarId(), result.getCarId());
    }

    @Test
    public void testDeleteCar() {
        OperationStatusModel result = carController.deleteCar("CAR123");

        assertEquals("DELETE", result.getOperationName());
        assertEquals("SUCCESS", result.getOperationResult());
    }

    @Test
    public void testCalculateLeaseRate() {
        when(carService.calculateLeaseRate(anyString(), any(LeaseRateRequestModel.class))).thenReturn(500.0);

        LeaseRateRequestModel leaseDetails = new LeaseRateRequestModel();
        String result = carController.calculateLeaseRate("CAR123", leaseDetails);

        assertEquals("Calculated Lease Rate for CarId : CAR123 : 500.0", result);
    }
}