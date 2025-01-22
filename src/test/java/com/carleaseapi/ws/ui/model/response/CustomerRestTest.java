package com.carleaseapi.ws.ui.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerRestTest {

    private CustomerRest customerRest;

    @BeforeEach
    public void setUp() {
        customerRest = new CustomerRest();
    }

    @Test
    public void testGetAndSetCustId() {
        String custId = "CUST123";
        customerRest.setCustId(custId);
        assertEquals(custId, customerRest.getCustId());
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "John";
        customerRest.setFirstName(firstName);
        assertEquals(firstName, customerRest.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Doe";
        customerRest.setLastName(lastName);
        assertEquals(lastName, customerRest.getLastName());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "john.doe@example.com";
        customerRest.setEmail(email);
        assertEquals(email, customerRest.getEmail());
    }
}