package com.carleaseapi.ws.shared.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for transferring data from Rest controller to
 * Repository.
 * 
 * @author Deepesh
 *
 */
public class CarDto implements Serializable {

	private static final long serialVersionUID = -8534134776176659527L;
	private long id;
	private String carId;
	private String make;
	private String model;
	private String version;
	private Integer noOfDoors;
	private Double co2Emission;
	private Double grossPrice;
	private Double netPrice;
	private Double milageKmsPerYear;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

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
