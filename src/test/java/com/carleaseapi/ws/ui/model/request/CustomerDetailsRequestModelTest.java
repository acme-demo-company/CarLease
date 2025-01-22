package com.carleaseapi.ws.ui.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDetailsRequestModelTest {

    private CustomerDetailsRequestModel customerDetailsRequestModel;

    @BeforeEach
    public void setUp() {
        customerDetailsRequestModel = new CustomerDetailsRequestModel();
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "John";
        customerDetailsRequestModel.setFirstName(firstName);
        assertEquals(firstName, customerDetailsRequestModel.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Doe";
        customerDetailsRequestModel.setLastName(lastName);
        assertEquals(lastName, customerDetailsRequestModel.getLastName());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "john.doe@example.com";
        customerDetailsRequestModel.setEmail(email);
        assertEquals(email, customerDetailsRequestModel.getEmail());
    }

    @Test
    public void testGetAndSetStreet() {
        String street = "Main Street";
        customerDetailsRequestModel.setStreet(street);
        assertEquals(street, customerDetailsRequestModel.getStreet());
    }

    @Test
    public void testGetAndSetHouseNumber() {
        Integer houseNumber = 123;
        customerDetailsRequestModel.setHouseNumber(houseNumber);
        assertEquals(houseNumber, customerDetailsRequestModel.getHouseNumber());
    }

    @Test
    public void testGetAndSetZipCode() {
        String zipCode = "12345";
        customerDetailsRequestModel.setZipCode(zipCode);
        assertEquals(zipCode, customerDetailsRequestModel.getZipCode());
    }

    @Test
    public void testGetAndSetPlace() {
        String place = "Springfield";
        customerDetailsRequestModel.setPlace(place);
        assertEquals(place, customerDetailsRequestModel.getPlace());
    }

    @Test
    public void testGetAndSetPhoneNumber() {
        String phoneNumber = "123-456-7890";
        customerDetailsRequestModel.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, customerDetailsRequestModel.getPhoneNumber());
    }
}