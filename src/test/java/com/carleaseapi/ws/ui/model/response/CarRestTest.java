package com.carleaseapi.ws.ui.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRestTest {

    private CarRest carRest;

    @BeforeEach
    public void setUp() {
        carRest = new CarRest();
    }

    @Test
    public void testGetAndSetCarId() {
        String carId = "CAR123";
        carRest.setCarId(carId);
        assertEquals(carId, carRest.getCarId());
    }

    @Test
    public void testGetAndSetMake() {
        String make = "Toyota";
        carRest.setMake(make);
        assertEquals(make, carRest.getMake());
    }

    @Test
    public void testGetAndSetModel() {
        String model = "Corolla";
        carRest.setModel(model);
        assertEquals(model, carRest.getModel());
    }

    @Test
    public void testGetAndSetVersion() {
        String version = "2021";
        carRest.setVersion(version);
        assertEquals(version, carRest.getVersion());
    }

    @Test
    public void testGetAndSetNetPrice() {
        Double netPrice = 25000.0;
        carRest.setNetPrice(netPrice);
        assertEquals(netPrice, carRest.getNetPrice());
    }

    @Test
    public void testGetAndSetMilageKmsPerYear() {
        Double milageKmsPerYear = 15000.0;
        carRest.setMilageKmsPerYear(milageKmsPerYear);
        assertEquals(milageKmsPerYear, carRest.getMilageKmsPerYear());
    }
}