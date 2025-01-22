package com.carleaseapi.ws.io.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerEntityTest {

    private CustomerEntity customerEntity;

    @BeforeEach
    public void setUp() {
        customerEntity = new CustomerEntity();
    }

    @Test
    public void testGetAndSetId() {
        long id = 1L;
        customerEntity.setId(id);
        assertEquals(id, customerEntity.getId());
    }

    @Test
    public void testGetAndSetCustId() {
        String custId = "CUST123";
        customerEntity.setCustId(custId);
        assertEquals(custId, customerEntity.getCustId());
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "John";
        customerEntity.setFirstName(firstName);
        assertEquals(firstName, customerEntity.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Doe";
        customerEntity.setLastName(lastName);
        assertEquals(lastName, customerEntity.getLastName());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "john.doe@example.com";
        customerEntity.setEmail(email);
        assertEquals(email, customerEntity.getEmail());
    }

    @Test
    public void testGetAndSetStreet() {
        String street = "Main Street";
        customerEntity.setStreet(street);
        assertEquals(street, customerEntity.getStreet());
    }

    @Test
    public void testGetAndSetHouseNumber() {
        Integer houseNumber = 123;
        customerEntity.setHouseNumber(houseNumber);
        assertEquals(houseNumber, customerEntity.getHouseNumber());
    }

    @Test
    public void testGetAndSetZipCode() {
        String zipCode = "12345";
        customerEntity.setZipCode(zipCode);
        assertEquals(zipCode, customerEntity.getZipCode());
    }

    @Test
    public void testGetAndSetPlace() {
        String place = "Springfield";
        customerEntity.setPlace(place);
        assertEquals(place, customerEntity.getPlace());
    }

    @Test
    public void testGetAndSetPhoneNumber() {
        String phoneNumber = "123-456-7890";
        customerEntity.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, customerEntity.getPhoneNumber());
    }
}