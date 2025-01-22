package com.carleaseapi.ws.ui.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.carleaseapi.ws.shared.dto.User;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testLogin() {
        String username = "testUser";
        String password = "testPassword";

        User user = userController.login(username, password);

        assertNotNull(user);
        assertNotNull(user.getToken());
        assertTrue(user.getToken().startsWith("Bearer "));
        assertTrue(user.getToken().length() > "Bearer ".length());
    }
}