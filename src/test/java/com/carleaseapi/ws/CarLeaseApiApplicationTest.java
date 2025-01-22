package com.carleaseapi.ws;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.carleaseapi.ws.security.JWTAuthorizationFilter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class CarLeaseApiApplicationTest {

    @InjectMocks
    private CarLeaseApiApplication carLeaseApiApplication;

    @Mock
    private HttpSecurity httpSecurity;

    @BeforeEach
    public void setUp() {
        carLeaseApiApplication = new CarLeaseApiApplication();
    }

    @Test
    public void testMain() {
        // Mocking SpringApplication.run
        SpringApplication mockSpringApplication = mock(SpringApplication.class);
        String[] args = {};
        SpringApplication.run(CarLeaseApiApplication.class, args);
        // No exception means success
    }

    @Test
    public void testWebSecurityConfigSecurityFilterChain() throws Exception {
        JWTAuthorizationFilter jwtAuthorizationFilter = mock(JWTAuthorizationFilter.class);
        when(httpSecurity.csrf()).thenReturn(httpSecurity);
        when(httpSecurity.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)).thenReturn(httpSecurity);
        when(httpSecurity.authorizeRequests()).thenReturn(httpSecurity);
        when(httpSecurity.antMatchers(HttpMethod.POST, "/user")).thenReturn(httpSecurity);
        when(httpSecurity.permitAll()).thenReturn(httpSecurity);
        when(httpSecurity.anyRequest()).thenReturn(httpSecurity);
        when(httpSecurity.authenticated()).thenReturn(httpSecurity);
        when(httpSecurity.build()).thenReturn(mock(SecurityFilterChain.class));

        SecurityFilterChain securityFilterChain = carLeaseApiApplication.webSecurityConfigSecurityFilterChain(httpSecurity);

        verify(httpSecurity).csrf();
        verify(httpSecurity).addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        verify(httpSecurity).authorizeRequests();
        verify(httpSecurity).antMatchers(HttpMethod.POST, "/user");
        verify(httpSecurity).permitAll();
        verify(httpSecurity).anyRequest();
        verify(httpSecurity).authenticated();
        verify(httpSecurity).build();
    }
}