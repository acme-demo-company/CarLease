package com.carleaseapi.ws.ui.model.request;

/**
 * 
 * Model Class for sending inputs for calculating Lease Rate for Car
 * 
 * @author Deepesh
 *
 */
public class LeaseRateRequestModel {
	private Integer duration;
	private Double interestRate;

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
