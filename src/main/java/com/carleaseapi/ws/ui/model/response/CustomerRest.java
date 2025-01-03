package com.carleaseapi.ws.ui.model.response;

/**
 * Class for populating response for Customer service
 * 
 * @author Admin
 *
 */
public class CustomerRest {
	private String custId;
	private String firstName;
	private String lastName;
	private String email;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
