package com.carleaseapi.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Car Entity Class mapped with database table
 * 
 * @author Deepesh
 *
 */

@Entity(name = "cars")
public class CarEntity implements Serializable {

	private static final long serialVersionUID = 8052124424578544195L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String carId;

	@Column(nullable = false, length = 50)
	private String make;

	@Column(nullable = false, length = 50)
	private String model;

	@Column(nullable = false, length = 50)
	private String version;

	@Column(nullable = false)
	private Integer noOfDoors;

	@Column(nullable = false)
	private Double co2Emission;

	@Column(nullable = false)
	private Double grossPrice;

	@Column(nullable = false)
	private Double netPrice;

	@Column(nullable = false)
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
