package com.lendico.task.model;

import java.time.LocalDateTime;

public class PlanGeneratorRequest {
	
	private double loanAmount;
	
	private float nominalRate;
	
	private int duration;
	
	private LocalDateTime startDate;

	public PlanGeneratorRequest(double loanAmount, float nominalRate, int duration, LocalDateTime startDate) {
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(float nominalRate) {
		this.nominalRate = nominalRate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
}
