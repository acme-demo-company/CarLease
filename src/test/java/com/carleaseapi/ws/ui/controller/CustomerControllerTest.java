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

import com.carleaseapi.ws.service.CustomerService;
import com.carleaseapi.ws.shared.dto.CustomerDto;
import com.carleaseapi.ws.ui.model.request.CustomerDetailsRequestModel;
import com.carleaseapi.ws.ui.model.request.OperationStatusModel;
import com.carleaseapi.ws.ui.model.response.CustomerRest;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private CustomerDto customerDto;
    private CustomerRest customerRest;

    @BeforeEach
    public void setUp() {
        customerDto = new CustomerDto();
        customerDto.setCustId("CUST123");
        customerDto.setFirstName("John");
        customerDto.setLastName("Doe");
        customerDto.setEmail("john.doe@example.com");

        customerRest = new CustomerRest();
        BeanUtils.copyProperties(customerDto, customerRest);
    }

    @Test
    public void testGetCustomer() {
        when(customerService.getCustomerByEmail(anyString())).thenReturn(customerDto);

        CustomerRest result = customerController.getCustomer("john.doe@example.com");

        assertEquals(customerRest.getCustId(), result.getCustId());
        assertEquals(customerRest.getFirstName(), result.getFirstName());
        assertEquals(customerRest.getLastName(), result.getLastName());
    }

    @Test
    public void testGetCustomers() {
        when(customerService.getCustomers()).thenReturn(Arrays.asList(customerDto));

        List<CustomerRest> result = customerController.getCustomers();

        assertEquals(1, result.size());
        assertEquals(customerRest.getCustId(), result.get(0).getCustId());
    }

    @Test
    public void testCreateCustomer() {
        when(customerService.createCustomer(any(CustomerDto.class))).thenReturn(customerDto);

        CustomerDetailsRequestModel customerDetails = new CustomerDetailsRequestModel();
        BeanUtils.copyProperties(customerDto, customerDetails);

        CustomerRest result = customerController.createCustomer(customerDetails);

        assertEquals(customerRest.getCustId(), result.getCustId());
    }

    @Test
    public void testUpdateCustomer() {
        when(customerService.updateCustomer(anyString(), any(CustomerDto.class))).thenReturn(customerDto);

        CustomerDetailsRequestModel customerDetails = new CustomerDetailsRequestModel();
        BeanUtils.copyProperties(customerDto, customerDetails);

        CustomerRest result = customerController.updateCustomer("CUST123", customerDetails);

        assertEquals(customerRest.getCustId(), result.getCustId());
    }

    @Test
    public void testDeleteCustomer() {
        OperationStatusModel result = customerController.deleteCustomer("CUST123");

        assertEquals("DELETE", result.getOperationName());
        assertEquals("SUCCESS", result.getOperationResult());
    }
}