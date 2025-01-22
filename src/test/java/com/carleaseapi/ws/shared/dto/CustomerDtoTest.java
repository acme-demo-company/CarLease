package com.carleaseapi.ws.shared.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDtoTest {

    private CustomerDto customerDto;

    @BeforeEach
    public void setUp() {
        customerDto = new CustomerDto();
    }

    @Test
    public void testGetAndSetId() {
        long id = 1L;
        customerDto.setId(id);
        assertEquals(id, customerDto.getId());
    }

    @Test
    public void testGetAndSetCustId() {
        String custId = "CUST123";
        customerDto.setCustId(custId);
        assertEquals(custId, customerDto.getCustId());
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "John";
        customerDto.setFirstName(firstName);
        assertEquals(firstName, customerDto.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Doe";
        customerDto.setLastName(lastName);
        assertEquals(lastName, customerDto.getLastName());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "john.doe@example.com";
        customerDto.setEmail(email);
        assertEquals(email, customerDto.getEmail());
    }

    @Test
    public void testGetAndSetStreet() {
        String street = "Main Street";
        customerDto.setStreet(street);
        assertEquals(street, customerDto.getStreet());
    }

    @Test
    public void testGetAndSetHouseNumber() {
        Integer houseNumber = 123;
        customerDto.setHouseNumber(houseNumber);
        assertEquals(houseNumber, customerDto.getHouseNumber());
    }

    @Test
    public void testGetAndSetZipCode() {
        String zipCode = "12345";
        customerDto.setZipCode(zipCode);
        assertEquals(zipCode, customerDto.getZipCode());
    }

    @Test
    public void testGetAndSetPlace() {
        String place = "Springfield";
        customerDto.setPlace(place);
        assertEquals(place, customerDto.getPlace());
    }

    @Test
    public void testGetAndSetPhoneNumber() {
        String phoneNumber = "123-456-7890";
        customerDto.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, customerDto.getPhoneNumber());
    }
}