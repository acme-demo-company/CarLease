package com.carleaseapi.ws.ui.model.response;

/**
 * Class for populating response for Car service
 * 
 * @author Admin
 *
 */
public class CarRest {
	private String carId;
	private String make;
	private String model;
	private String version;
	private Double netPrice;
	private Double milageKmsPerYear;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	public Double getMilageKmsPerYear() {
		return milageKmsPerYear;
	}

	public void setMilageKmsPerYear(Double milageKmsPerYear) {
		this.milageKmsPerYear = milageKmsPerYear;
	}

}
