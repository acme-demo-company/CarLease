package com.carleaseapi.ws.ui.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaseRateRequestModelTest {

    private LeaseRateRequestModel leaseRateRequestModel;

    @BeforeEach
    public void setUp() {
        leaseRateRequestModel = new LeaseRateRequestModel();
    }

    @Test
    public void testGetAndSetInterestRate() {
        Double interestRate = 5.5;
        leaseRateRequestModel.setInterestRate(interestRate);
        assertEquals(interestRate, leaseRateRequestModel.getInterestRate());
    }

    @Test
    public void testGetAndSetDuration() {
        Integer duration = 36;
        leaseRateRequestModel.setDuration(duration);
        assertEquals(duration, leaseRateRequestModel.getDuration());
    }
}