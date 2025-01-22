package com.carleaseapi.ws.shared;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    private Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @Test
    public void testGenerateCarId() {
        int length = 10;
        String carId = utils.generateCarId(length);
        assertNotNull(carId);
        assertEquals(length, carId.length());
    }

    @Test
    public void testGenerateCustId() {
        int length = 10;
        String custId = utils.generateCustId(length);
        assertNotNull(custId);
        assertEquals(length, custId.length());
    }
}