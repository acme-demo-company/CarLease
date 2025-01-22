package com.carleaseapi.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.carleaseapi.ws.security.JWTAuthorizationFilter;

/**
 * Car Lease API Application Class. Car Lease API Application is responsible for
 * Maintaining Customers, Cars and Calculate Car Lease.
 * 
 * @author Deepesh
 *
 */
@SpringBootApplication
public class CarLeaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLeaseApiApplication.class, args);
	}

	@Bean
	SecurityFilterChain webSecurityConfigSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(),
						UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll().anyRequest().authenticated();
		return http.build();
	}
}
