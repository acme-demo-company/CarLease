package com.carleaseapi.ws.shared.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarDtoTest {

    private CarDto carDto;

    @BeforeEach
    public void setUp() {
        carDto = new CarDto();
    }

    @Test
    public void testGetAndSetId() {
        long id = 1L;
        carDto.setId(id);
        assertEquals(id, carDto.getId());
    }

    @Test
    public void testGetAndSetCarId() {
        String carId = "CAR123";
        carDto.setCarId(carId);
        assertEquals(carId, carDto.getCarId());
    }

    @Test
    public void testGetAndSetMake() {
        String make = "Toyota";
        carDto.setMake(make);
        assertEquals(make, carDto.getMake());
    }

    @Test
    public void testGetAndSetModel() {
        String model = "Corolla";
        carDto.setModel(model);
        assertEquals(model, carDto.getModel());
    }

    @Test
    public void testGetAndSetVersion() {
        String version = "2021";
        carDto.setVersion(version);
        assertEquals(version, carDto.getVersion());
    }

    @Test
    public void testGetAndSetNoOfDoors() {
        Integer noOfDoors = 4;
        carDto.setNoOfDoors(noOfDoors);
        assertEquals(noOfDoors, carDto.getNoOfDoors());
    }

    @Test
    public void testGetAndSetCo2Emission() {
        Double co2Emission = 120.5;
        carDto.setCo2Emission(co2Emission);
        assertEquals(co2Emission, carDto.getCo2Emission());
    }

    @Test
    public void testGetAndSetGrossPrice() {
        Double grossPrice = 30000.0;
        carDto.setGrossPrice(grossPrice);
        assertEquals(grossPrice, carDto.getGrossPrice());
    }

    @Test
    public void testGetAndSetNetPrice() {
        Double netPrice = 25000.0;
        carDto.setNetPrice(netPrice);
        assertEquals(netPrice, carDto.getNetPrice());
    }

    @Test
    public void testGetAndSetMilageKmsPerYear() {
        Double milageKmsPerYear = 15000.0;
        carDto.setMilageKmsPerYear(milageKmsPerYear);
        assertEquals(milageKmsPerYear, carDto.getMilageKmsPerYear());
    }
}