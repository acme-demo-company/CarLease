package com.carleaseapi.ws.exceptions;

/**
 * Generic exception class for CarLeaseAPI
 * @author Admin
 *
 */
public class CarLeaseApiException extends RuntimeException{

	private static final long serialVersionUID = -3605080398191557460L;
	
	public CarLeaseApiException(String message) {
		super(message);
	}
	

}
