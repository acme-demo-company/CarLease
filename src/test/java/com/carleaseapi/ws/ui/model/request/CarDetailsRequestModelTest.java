package com.carleaseapi.ws.ui.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarDetailsRequestModelTest {

    private CarDetailsRequestModel carDetailsRequestModel;

    @BeforeEach
    public void setUp() {
        carDetailsRequestModel = new CarDetailsRequestModel();
    }

    @Test
    public void testGetAndSetMake() {
        String make = "Toyota";
        carDetailsRequestModel.setMake(make);
        assertEquals(make, carDetailsRequestModel.getMake());
    }

    @Test
    public void testGetAndSetModel() {
        String model = "Corolla";
        carDetailsRequestModel.setModel(model);
        assertEquals(model, carDetailsRequestModel.getModel());
    }

    @Test
    public void testGetAndSetVersion() {
        String version = "2021";
        carDetailsRequestModel.setVersion(version);
        assertEquals(version, carDetailsRequestModel.getVersion());
    }

    @Test
    public void testGetAndSetNoOfDoors() {
        Integer noOfDoors = 4;
        carDetailsRequestModel.setNoOfDoors(noOfDoors);
        assertEquals(noOfDoors, carDetailsRequestModel.getNoOfDoors());
    }

    @Test
    public void testGetAndSetCo2Emission() {
        Double co2Emission = 120.5;
        carDetailsRequestModel.setCo2Emission(co2Emission);
        assertEquals(co2Emission, carDetailsRequestModel.getCo2Emission());
    }

    @Test
    public void testGetAndSetGrossPrice() {
        Double grossPrice = 30000.0;
        carDetailsRequestModel.setGrossPrice(grossPrice);
        assertEquals(grossPrice, carDetailsRequestModel.getGrossPrice());
    }

    @Test
    public void testGetAndSetNetPrice() {
        Double netPrice = 25000.0;
        carDetailsRequestModel.setNetPrice(netPrice);
        assertEquals(netPrice, carDetailsRequestModel.getNetPrice());
    }

    @Test
    public void testGetAndSetMilageKmsPerYear() {
        Double milageKmsPerYear = 15000.0;
        carDetailsRequestModel.setMilageKmsPerYear(milageKmsPerYear);
        assertEquals(milageKmsPerYear, carDetailsRequestModel.getMilageKmsPerYear());
    }
}