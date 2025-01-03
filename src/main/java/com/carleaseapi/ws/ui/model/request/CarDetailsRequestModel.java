package com.carleaseapi.ws.ui.model.request;

/**
 * 
 * REST Request mapping class for CAR Deatils. This is used as input for Post
 * and put mapping
 * 
 * @author Deepesh
 *
 */
public class CarDetailsRequestModel {

	private String make;
	private String model;
	private String version;
	private Integer noOfDoors;
	private Double co2Emission;
	private Double grossPrice;
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

	public Integer getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(Integer noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public Double getCo2Emission() {
		return co2Emission;
	}

	public void setCo2Emission(Double co2Emission) {
		this.co2Emission = co2Emission;
	}

	public Double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(Double grossPrice) {
		this.grossPrice = grossPrice;
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
