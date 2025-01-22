package com.carleaseapi.ws.ui.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperationStatusModelTest {

    private OperationStatusModel operationStatusModel;

    @BeforeEach
    public void setUp() {
        operationStatusModel = new OperationStatusModel();
    }

    @Test
    public void testGetAndSetOperationResult() {
        String operationResult = "SUCCESS";
        operationStatusModel.setOperationResult(operationResult);
        assertEquals(operationResult, operationStatusModel.getOperationResult());
    }

    @Test
    public void testGetAndSetOperationName() {
        String operationName = "DELETE";
        operationStatusModel.setOperationName(operationName);
        assertEquals(operationName, operationStatusModel.getOperationName());
    }
}