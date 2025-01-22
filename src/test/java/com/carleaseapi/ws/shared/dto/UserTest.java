package com.carleaseapi.ws.shared.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetAndSetUser() {
        String username = "testUser";
        user.setUser(username);
        assertEquals(username, user.getUser());
    }

    @Test
    public void testGetAndSetPwd() {
        String password = "testPassword";
        user.setPwd(password);
        assertEquals(password, user.getPwd());
    }

    @Test
    public void testGetAndSetToken() {
        String token = "testToken";
        user.setToken(token);
        assertEquals(token, user.getToken());
    }
}