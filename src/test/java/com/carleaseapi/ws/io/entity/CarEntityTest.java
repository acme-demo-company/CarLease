package com.carleaseapi.ws.io.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarEntityTest {

    private CarEntity carEntity;

    @BeforeEach
    public void setUp() {
        carEntity = new CarEntity();
    }

    @Test
    public void testGetAndSetId() {
        long id = 1L;
        carEntity.setId(id);
        assertEquals(id, carEntity.getId());
    }

    @Test
    public void testGetAndSetCarId() {
        String carId = "CAR123";
        carEntity.setCarId(carId);
        assertEquals(carId, carEntity.getCarId());
    }

    @Test
    public void testGetAndSetMake() {
        String make = "Toyota";
        carEntity.setMake(make);
        assertEquals(make, carEntity.getMake());
    }

    @Test
    public void testGetAndSetModel() {
        String model = "Corolla";
        carEntity.setModel(model);
        assertEquals(model, carEntity.getModel());
    }

    @Test
    public void testGetAndSetVersion() {
        String version = "2021";
        carEntity.setVersion(version);
        assertEquals(version, carEntity.getVersion());
    }

    @Test
    public void testGetAndSetNoOfDoors() {
        Integer noOfDoors = 4;
        carEntity.setNoOfDoors(noOfDoors);
        assertEquals(noOfDoors, carEntity.getNoOfDoors());
    }

    @Test
    public void testGetAndSetCo2Emission() {
        Double co2Emission = 120.5;
        carEntity.setCo2Emission(co2Emission);
        assertEquals(co2Emission, carEntity.getCo2Emission());
    }

    @Test
    public void testGetAndSetGrossPrice() {
        Double grossPrice = 30000.0;
        carEntity.setGrossPrice(grossPrice);
        assertEquals(grossPrice, carEntity.getGrossPrice());
    }

    @Test
    public void testGetAndSetNetPrice() {
        Double netPrice = 25000.0;
        carEntity.setNetPrice(netPrice);
        assertEquals(netPrice, carEntity.getNetPrice());
    }

    @Test
    public void testGetAndSetMilageKmsPerYear() {
        Double milageKmsPerYear = 15000.0;
        carEntity.setMilageKmsPerYear(milageKmsPerYear);
        assertEquals(milageKmsPerYear, carEntity.getMilageKmsPerYear());
    }
}